
noun_m:: -> Bool
--noun_m x = elem x [tempo,['c','a','c','a','d','o','r'],['c','a','c','a','d','o','r'],['r','i','o'],['m','a','r'],['v','e','n','t','o'],['m','a','r','t','e','l','o'],['c','a','c','h','o','r','r','o'],['t','a','m','b','o','r'],['s','i','n','o']]
noun_m x = elem x ['tempo']



--nomes masculinos singular
noun_m :: [String]
noun_m  = ["tempo","cacador","rosto","rio","mar","vento","martelo","cachorro","tambor","sino"]
--determinantes masculinos singular
determiner_m :: [String]
determiner_m = ["o","O"]


--noun_m ::= "texto1" | "texto2"


type Noun_m = String
data Noun_m = "tempo"
            | "cacador"
    deriving Show




--data Noun_phrase = determiner_m noun_m
