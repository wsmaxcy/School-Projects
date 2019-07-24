--Will Maxcy

{- CSci 450/503, Fall 2014
   Homework #4: Sandwich DSL
   H. Conrad Cunningham
   27 Ocotber 2014

1234567890123456789012345678901234567890123456789012345678901234567890

This is the SandwichDSL base code from the case study. It can be
expanded to build the module for Assignment #4.

-}

module SandwichDSL
where

-- Used functions from these modules in my implementation
import Data.Maybe
import Data.List

{- Haskell data type definitions from "Building the DSL" -}

data Platter   = Platter [Sandwich] 
                 deriving Show

data Sandwich  = Sandwich [Layer]
                 deriving Show

data Layer     = Bread Bread         | Meat Meat           |
                 Cheese Cheese       | Vegetable Vegetable | 
                 Condiment Condiment
                 deriving (Eq,Show)

data Bread     = White | Wheat | Rye
                 deriving (Eq,Show)

data Meat      = Turkey | Chicken | Ham | RoastBeef | Tofu
                 deriving (Eq,Show)

data Cheese    = American | Swiss | Jack | Cheddar
                 deriving (Eq,Show)

data Vegetable = Tomato | Onion | Lettuce | BellPepper
                 deriving (Eq,Show)

data Condiment = Mayo | Mustard | Ketchup | Relish | Tabasco
                 deriving (Eq,Show)

-- Function type signatures given in section
-- newSandwich :: Bread -> Sandwich
-- addLayer ::    Sandwich -> Layer -> Sandwich
-- newPlatter ::  Platter
-- addSandwich :: Platter -> Sandwich -> Platter


{- Haskell data type definitions from 
   "Compiling the Program for the SueChef Controller"
-}

data SandwichOp = StartSandwich    | FinishSandwich |
                  AddBread Bread   | AddMeat Meat   |
                  AddCheese Cheese | AddVegetable Vegetable | 
                  AddCondiment Condiment |
                  StartPlatter | MoveToPlatter | FinishPlatter 
                  deriving (Eq, Show) 

data Program = Program [SandwichOp]
               deriving Show

------------ End of SandwichDSL_base ----------
--Set 1: 1
newSandwich :: Bread -> Sandwich
newSandwich x =Sandwich [Bread x]

addLayer :: Sandwich -> Layer -> Sandwich
addLayer (Sandwich x) y = Sandwich (y:x)

newPlatter :: Platter
newPlatter = (Platter [])

addSandwich :: Platter -> Sandwich -> Platter
addSandwich (Platter x) y = Platter (y:x)

--2
isBread :: Layer -> Bool
isBread (Bread x)     = True
isBread (Cheese _)    = False
isBread (Vegetable _) = False
isBread (Meat _)      = False
isBread (Condiment _) = False


isMeat :: Layer -> Bool
isMeat (Meat x)      = True
isMeat (Bread x)     = False
isMeat (Cheese _)    = False
isMeat (Vegetable _) = False
isMeat (Condiment _) = False

isCheese :: Layer -> Bool
isCheese (Cheese x)    = True
isCheese (Meat x)      = False
isCheese (Bread x)     = False
isCheese (Vegetable _) = False
isCheese (Condiment _) = False

isVegetable :: Layer -> Bool
isVegetable (Vegetable x) = True
isVegetable (Meat x)      = False
isVegetable (Bread x)     = False
isVegetable (Cheese _)    = False
isVegetable (Condiment _) = False

isCondiment :: Layer -> Bool
isCondiment (Condiment x) = True
isCondiment (Meat x)      = False
isCondiment (Bread x)     = False
isCondiment (Cheese _)    = False
isCondiment (Vegetable _) = False


--3
noMeat :: Sandwich -> Bool
noMeat (Sandwich []) = True
noMeat (Sandwich (x:xs))
   | x == (Meat Turkey)    = False
   | x == (Meat Chicken)   = False
   | x == (Meat Ham)       = False
   | x == (Meat RoastBeef) = False
   | x == (Meat Tofu)      = False
   | otherwise = noMeat (Sandwich xs)

--4
--omitted both of these

--5
prices = [(Bread White,20),(Bread Wheat,30),(Bread Rye,30), 
          (Meat Turkey,100),(Meat Chicken,80),(Meat Ham,120),
          (Meat RoastBeef,140),(Meat Tofu,50),
          (Cheese American,50),(Cheese Swiss,60),
          (Cheese Jack,60),(Cheese Cheddar,60),
          (Vegetable Tomato,25),(Vegetable Onion,20),
          (Vegetable Lettuce,20),(Vegetable BellPepper,25),
          (Condiment Mayo,5),(Condiment Mustard,4),
          (Condiment Ketchup,4),(Condiment Relish,10),
          (Condiment Tabasco,5) 
         ]

priceSandwich :: Sandwich -> Int
priceSandwich (Sandwich x) = findPrice(x) 0

findPrice :: [Layer] -> Int -> Int
findPrice [] x = x
findPrice (x:xs) price = findPrice xs ((fromJust(lookup x prices)) + price)


--6
--I decided that a sandwich is equivilant only if they contain the exact same 
--layers in the exact same order. There is already an OSO so order matters when
--dealing with sandwiches

eqSandwich :: Sandwich -> Sandwich -> Bool
eqSandwich (Sandwich []) (Sandwich []) = True
eqSandwich (Sandwich []) (Sandwich x)  = False
eqSandwich (Sandwich x) (Sandwich [])  = False
eqSandwich (Sandwich (x:xs)) (Sandwich (y:ys))
   | x == y = eqSandwich(Sandwich xs) (Sandwich ys)
   | otherwise = False

--Set 2: 1
findEnd :: Layer -> SandwichOp
findEnd (Bread Rye)            = AddBread Rye
findEnd (Bread White)          = AddBread White
findEnd (Bread Wheat)          = AddBread Wheat
findEnd (Meat Turkey)          = AddMeat Turkey
findEnd (Meat Chicken)         = AddMeat Chicken
findEnd (Meat Ham)             = AddMeat Ham
findEnd (Meat RoastBeef)       = AddMeat RoastBeef
findEnd (Meat Tofu)            = AddMeat Tofu
findEnd (Cheese American)      = AddCheese American
findEnd (Cheese Swiss)         = AddCheese Swiss
findEnd (Cheese Jack)          = AddCheese Jack
findEnd (Cheese Cheddar)       = AddCheese Cheddar
findEnd (Vegetable Tomato)     = AddVegetable Tomato
findEnd (Vegetable Onion)      = AddVegetable Onion
findEnd (Vegetable Lettuce)    = AddVegetable Lettuce
findEnd (Vegetable BellPepper) = AddVegetable BellPepper
findEnd (Condiment Mayo)       = AddCondiment Mayo
findEnd (Condiment Mustard)    = AddCondiment Mustard
findEnd (Condiment Ketchup)    = AddCondiment Ketchup
findEnd (Condiment Relish)     = AddCondiment Relish
findEnd (Condiment Tabasco)    = AddCondiment Tabasco

compileSandwich :: Sandwich -> [SandwichOp]
compileSandwich (Sandwich x) = [StartSandwich] ++ compileSandwich'(Sandwich (x))

compileSandwich' :: Sandwich -> [SandwichOp]
compileSandwich' (Sandwich []) = [FinishSandwich,MoveToPlatter]
compileSandwich' (Sandwich (x:xs)) = [findEnd(x)] ++ compileSandwich'(Sandwich(xs))

--2
--could not get this part to work :(
--compile :: Platter -> Program
--compile (Platter (x)) = (Program (compile' (Program (x))))

--compile' :: Platter -> [SandwichOp]
--compile' (Platter []) = [FinishPlatter]
--compile' (x:xs) = (compileSandwich(Sandwich (x))) ++ compile'(Platter(xs))