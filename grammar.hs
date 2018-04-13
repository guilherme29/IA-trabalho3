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


data Palavra = Detf String
            | Detm String
            | Nounm String
            | Nounm_p String
            | Nounf String
            | Nounf_p String
            | Verb String
            | Verb_p String
            | Conjf String
            | Conjm String
            | Conjf_p String
            | Conjm_p String
            | Prop String


instance Show Palavra where
  show (Detf x)     = "determiner(" ++ x ++ ")"
  show (Detm x)     = "determiner(" ++ x ++ ")"
  show (Nounm x)    = "noun(" ++ x ++ ")"
  show (Nounm_p x)  = "noun(" ++ x ++ ")"
  show (Nounf x)    = "noun(" ++ x ++ ")"
  show (Nounf_p x)  = "noun(" ++ x ++ ")"
  show (Verb x)     = "verb(" ++ x ++ ")"
  show (Verb_p x)   = "verb(" ++ x ++ ")"
  show (Conjf x)    = "conjuction(" ++ x ++ ")"
  show (Conjm x)    = "conjuction(" ++ x ++ ")"
  show (Conjf_p x)  = "conjuction(" ++ x ++ ")"
  show (Conjm_p x)  = "conjuction(" ++ x ++ ")"
  show (Prop x)     = "propostion(" ++ x ++ ")"

data Sentence = Sentence Palavra Palavra Palavra
instance Show Sentence where
  show (Sentence d n v) = "sentence(" ++ (show d) ++ "," ++ (show n) ++ "," ++ (show v) ++ ")"

parse :: [String] -> Sentence
parse [x1,x2,x3] = Sentence (Detf x1) (parseNoun x2) (Verb x3)

{-
evaluate :: [String] -> Bool
evaluate xs = evaluate2 (parse xs)

evaluate2 :: Sentence -> Bool
evaluate2 (Sentence x1 x2 x3) = isDetf x1 && isNounm x2 && isVerb x3
-}

isDetf :: Palavra -> Bool
isDetf (Detf x) = elem x detf
isDetf _ = False

isNounm :: Palavra -> Bool
isNounm (Nounm x) = elem x nounm
isNounm _ = False

isVerb :: Palavra -> Bool
isVerb (Verb x) = elem x verb
isVerb _ = False


--parses
parseNoun :: String -> Palavra
parseNoun x
  | elem x nounm = Nounm x
  | elem x nounf = Nounf x
  | elem x nounm_p = Nounm_p x
  | elem x nounf_p = Nounf_p x

--parseNoun_p :: String -> Palavra
