--lista de determinantes
detf    = ["A", "a"]
detm    = ["O", "o"]
detf_p  = ["As","as"]
detm_p  = ["Os","os"]
--lista de nomes
nounf   = ["menina","floresta","mae","vida","noticia","cidade","porta"]
nounm   = ["tempo","cacador","rosto","rio","mar","vento","martelo","cachorro","tambor","sino"]
nounf_p = ["lagrimas","meninas"]
nounm_p = ["lobos","cacadores"]
--lista de verbos
verb    = ["corre","correu","bateu","corria"]
verb_p  = ["correm","correram","bateram","corriam"]
--lista de conjuncoes
conjf   = ["pela","na"]
conjm   = ["pelo","no"]
conjf_p = ["pelas","nas"]
conjm_p = ["pelos","nos"]
--lista de proposicoes
prop = ["para","com"]



nomesSingular  = ["menina", "menino"]
nomesPlural    = ["meninas", "meninos"]
verbos = ["morreu", "suicidou"]

data Palavra = Detf String
            | NomeSingular String
            | NomePlural String
            | Verbo String

instance Show Palavra where
  show (Detf x) = x
  show (NomeSingular x) = "NomeSingular(" ++ x ++ ")"
  show (NomePlural x) = "NomePlural(" ++ x ++ ")"
  show (Verbo x) = x

data Sentence = Sentence Palavra Palavra Palavra
instance Show Sentence where
  show (Sentence d n v) = "Sentence(" ++ (show d) ++ "," ++ (show n) ++ "," ++ (show v) ++ ")"

parse :: [String] -> Sentence
parse [x1,x2,x3] = Sentence (Detf x1) (parseNome x2) (Verbo x3)

evaluate :: [String] -> Bool
evaluate xs = evaluate2 (parse xs)

evaluate2 :: Sentence -> Bool
evaluate2 (Sentence x1 x2 x3) = isDetf x1 && isNome x2 && isVerbo x3

isDetf :: Palavra -> Bool
isDetf (Detf x) = elem x detf
isDetf _ = False

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
