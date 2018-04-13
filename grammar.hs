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
            | Detf_p String
            | Detm_p String
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
  show (Detf_p x)   = "determiner(" ++ x ++ ")"
  show (Detm_p x)   = "determiner(" ++ x ++ ")"
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

data Sentence3 = Sentence3 Palavra Palavra Palavra
instance Show Sentence3 where
    show (Sentence3 d n v) = "sentence(" ++ (show d) ++ "," ++ (show n) ++ "," ++ (show v) ++ ")"

parse3 :: [String] -> Sentence3
parse3 [x1,x2,x3] = Sentence3 (parseDet x1) (parseNoun x2) (parseVerb x3)

evaluate3 :: [String] -> Bool
evaluate3 xs = evaluate3aux (parse3 xs)

evaluate3aux :: Sentence3 -> Bool
evaluate3aux (Sentence3 x1 x2 x3)   = isDetf x1 && isNounf x2 && isVerb x3
                                    ||isDetm x1 && isNounm x2 && isVerb x3
                                    ||isDetf_p x1 && isNounf_p x2 && isVerb_p x3
                                    ||isDetm_p x1 && isNounm_p x2 && isVerb_p x3


data Sentence5 = Sentence5 Palavra Palavra Palavra Palavra Palavra
instance Show Sentence5 where
    show (Sentence5 d n v a1 a2) = "sentence(" ++ (show d) ++ "," ++ (show n) ++ "," ++ (show v) ++ "," ++ (show a1) ++ "," ++ (show a2) ++ ")"


--funções isX
isDetf :: Palavra -> Bool
isDetf (Detf x) = elem x detf
isDetf _ = False

isDetm :: Palavra -> Bool
isDetm (Detm x) = elem x detm
isDetm _ = False

isDetf_p :: Palavra -> Bool
isDetf_p (Detf_p x) = elem x detf_p
isDetf_p _ = False

isDetm_p :: Palavra -> Bool
isDetm_p (Detm_p x) = elem x detm_p
isDetm_p _ = False

isNounf :: Palavra -> Bool
isNounf (Nounf x) = elem x nounf
isNounf _ = False

isNounm :: Palavra -> Bool
isNounm (Nounm x) = elem x nounm
isNounm _ = False

isNounf_p :: Palavra -> Bool
isNounf_p (Nounf_p x) = elem x nounf_p
isNounf_p _ = False

isNounm_p :: Palavra -> Bool
isNounm_p (Nounm_p x) = elem x nounm_p
isNounm_p _ = False

isVerb :: Palavra -> Bool
isVerb (Verb x) = elem x verb
isVerb _ = False

isVerb_p :: Palavra -> Bool
isVerb_p (Verb_p x) = elem x verb_p
isVerb_p _ = False

isConjf :: Palavra -> Bool
isConjf (Conjf x) = elem x conjf
isConjf _ = False

isConjm :: Palavra -> Bool
isConjm (Conjm x) = elem x conjm
isConjm _ = False

isConjf_p :: Palavra -> Bool
isConjf_p (Conjf_p x) = elem x conjf_p
isConjf_p _ = False

isConjm_p :: Palavra -> Bool
isConjm_p (Conjm_p x) = elem x conjm_p
isConjm_p _ = False

isProp :: Palavra -> Bool
isProp (Prop x) = elem x prop
isProp _ = False



--parses
parseDet :: String -> Palavra
parseDet x
    | elem x detf = Detf x
    | elem x detm = Detm x
    | elem x detf_p = Detf_p x
    | elem x detm_p = Detm_p x

parseNoun :: String -> Palavra
parseNoun x
    | elem x nounm = Nounm x
    | elem x nounf = Nounf x
    | elem x nounm_p = Nounm_p x
    | elem x nounf_p = Nounf_p x

parseVerb :: String -> Palavra
parseVerb x
    | elem x verb = Verb x
    | otherwise = Verb_p x

parseConj :: String -> Palavra
parseConj x
    | elem x conjf = Conjf x
    | elem x conjm = Conjm x
    | elem x conjf_p = Conjf_p x
    | elem x conjm_p = Conjm_p x

parseProp :: String -> Palavra
parseProp x
    | elem x prop = Prop x
