det    = ["A", "O"]
nomesSingular  = ["menina", "menino"]
nomesPlural    = ["meninas", "meninos"]
verbos = ["morreu", "suicidou"]

data Palavra = Det String
          | NomeSingular String
          | NomePlural String
          | Verbo String

instance Show Palavra where
  show (Det x) = x
  show (NomeSingular x) = "NomeSingular(" ++ x ++ ")"
  show (NomePlural x) = "NomePlural(" ++ x ++ ")"
  show (Verbo x) = x

data Sentence = Sentence Palavra Palavra Palavra
instance Show Sentence where
  show (Sentence d n v) = "Sentence(" ++ (show d) ++ "," ++ (show n) ++ "," ++ (show v) ++ ")"

parse :: [String] -> Sentence
parse [x1,x2,x3] = Sentence (Det x1) (parseNome x2) (Verbo x3)

evaluate :: [String] -> Bool
evaluate xs = evaluate2 (parse xs)

evaluate2 :: Sentence -> Bool
evaluate2 (Sentence x1 x2 x3) = isDet x1 && isNome x2 && isVerbo x3

isDet :: Palavra -> Bool
isDet (Det x) = elem x det
isDet _ = False

isNome :: Palavra -> Bool
isNome (NomeSingular x) = elem x nomesSingular
isNome _ = False

isVerbo :: Palavra -> Bool
isVerbo (Verbo x) = elem x verbos
isVerbo _ = False

parseNome :: String -> Palavra
parseNome x
  | elem x nomesSingular = NomeSingular x
  | otherwise = NomePlural x
