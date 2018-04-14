/* exemplo duma query: */
% ?- sentence(X,['A',menina,corre],[]).
% X = sent(noun_phrase(det('A'), noun_f(menina)), verbal_phrase(verb(corre))) .

sentence(sent(Np,Vp)) --> noun_phrase(Np), verbal_phrase(Vp).
sentence(sent(Npp,Vpp)) --> noun_phrase_p(Npp), verbal_phrase_p(Vpp).

noun_phrase(noun_phrase(Df,Nf))  --> determiner_f(Df), noun_f(Nf).
noun_phrase(noun_phrase(Dm,Nm))  --> determiner_m(Dm), noun_m(Nm).
noun_phrase(noun_phrase(Nf))     --> noun_f(Nf).
noun_phrase(noun_phrase(Nm))     --> noun_m(Nm).

noun_phrase_p(noun_phrase(Dpf,Npf)) --> determiner_p_f(Dpf), noun_p_f(Npf).
noun_phrase_p(noun_phrase(Dpm,Npm)) --> determiner_p_m(Dpm), noun_p_m(Npm).
noun_phrase_p(noun_phrase(Npf))     --> noun_p_f(Npf).
noun_phrase_p(noun_phrase(Npm))     --> noun_p_m(Npm).

% verbal_phrase
verbal_phrase(verbal_phrase(Verb))  --> verb(Verb).
verbal_phrase(verbal_phrase(Verb,Prop,Df,Nf))   --> verb(Verb), prop(Prop), determiner_f(Df), noun_f(Nf).
verbal_phrase(verbal_phrase(Verb,Prop,Dm,Nm))   --> verb(Verb), prop(Prop), determiner_m(Dm), noun_m(Nm).

verbal_phrase(verbal_phrase(Verb,Prop,Dpf,Npf)) --> verb(Verb), prop(Prop), determiner_p_f(Dpf), noun_p_f(Npf).
verbal_phrase(verbal_phrase(Verb,Prop,Dpm,Npm)) --> verb(Verb), prop(Prop), determiner_p_m(Dpm), noun_p_m(Npm).

verbal_phrase(verbal_phrase(Verb,Cf,Nf))    --> verb(Verb), conjuncao_f(Cf), noun_f(Nf).
verbal_phrase(verbal_phrase(Verb,Cm,Nm))    --> verb(Verb), conjuncao_m(Cm), noun_m(Nm).

verbal_phrase(verbal_phrase(Verb,Cpf,Npf))  --> verb(Verb), conjuncao_p_f(Cpf), noun_p_f(Npf).
verbal_phrase(verbal_phrase(Verb,Cpm,Npm))  --> verb(Verb), conjuncao_p_m(Cpm), noun_p_m(Npm).

verbal_phrase(verbal_phrase(Verb,Df,Nf))    --> verb(Verb), determiner_f(Df), noun_f(Nf).
verbal_phrase(verbal_phrase(Verb,Dm,Nm))    --> verb(Verb), determiner_m(Dm), noun_m(Nm).

verbal_phrase(verbal_phrase(Verb,Dpf,Npf))  --> verb(Verb), determiner_p_f(Dpf), noun_p_f(Npf).
verbal_phrase(verbal_phrase(Verb,Dpm,Npm))  --> verb(Verb), determiner_p_m(Dpm), noun_p_m(Npm).

% verbal_phrase_p
verbal_phrase_p(verbal_phrase(Verbp))  --> verb_p(Verbp).
verbal_phrase_p(verbal_phrase(Verbp,Prop,Df,Nf)) --> verb_p(Verbp), prop(Prop), determiner_f(Df), noun_f(Nf).
verbal_phrase_p(verbal_phrase(Verbp,Prop,Dm,Nm)) --> verb_p(Verbp), prop(Prop), determiner_m(Dm), noun_m(Nm).

verbal_phrase_p(verbal_phrase(Verbp,Prop,Dpf,Npf)) --> verb_p(Verbp), prop(Prop), determiner_p_f(Dpf), noun_p_f(Npf).
verbal_phrase_p(verbal_phrase(Verbp,Prop,Dpm,Npm)) --> verb_p(Verbp), prop(Prop), determiner_p_m(Dpm), noun_p_m(Npm).

verbal_phrase_p(verbal_phrase(Verbp,Cf,Nf))     --> verb_p(Verbp), conjuncao_f(Cf), noun_f(Nf).
verbal_phrase_p(verbal_phrase(Verbp,Cm,Nm))     --> verb_p(Verbp), conjuncao_m(Cm), noun_m(Nm).

verbal_phrase_p(verbal_phrase(Verbp,Cpf,Npf))   --> verb_p(Verbp), conjuncao_p_f(Cpf), noun_p_f(Npf).
verbal_phrase_p(verbal_phrase(Verbp,Cpm,Npm))   --> verb_p(Verbp), conjuncao_p_m(Cpm), noun_p_m(Npm).

verbal_phrase_p(verbal_phrase(Verbp,Df,Nf))     --> verb_p(Verbp), determiner_f(Df), noun_f(Nf).
verbal_phrase_p(verbal_phrase(Verbp,Dm,Nm))     --> verb_p(Verbp), determiner_m(Dm), noun_m(Nm).

verbal_phrase_p(verbal_phrase(Verbp,Dpf,Npf))   --> verb_p(Verbp), determiner_p_f(Dpf), noun_p_f(Npf).
verbal_phrase_p(verbal_phrase(Verbp,Dpm,Npm))   --> verb_p(Verbp), determiner_p_m(Dpm), noun_p_m(Npm).


% lista dos determinantes
determiner_f(det(a))        --> [a].
determiner_f(det('A'))      --> ['A'].
determiner_m(det(o))        --> [o].
determiner_m(det('O'))      --> ['O'].
determiner_p_f(det(as))     --> [as].
determiner_p_f(det('As'))   --> ['As'].
determiner_p_m(det(os))     --> [os].
determiner_p_m(det('Os'))   --> ['Os'].

% nomes femininos singular

noun_f(noun_f(menina))  --> [menina].
noun_f(noun_f(floresta))--> [floresta].
noun_f(noun_f(mae))     --> [mae].
noun_f(noun_f(vida))    --> [vida].
noun_f(noun_f(noticia)) --> [noticia].
noun_f(noun_f(cidade))  --> [cidade].
noun_f(noun_f(porta))   --> [porta].

% nomes femininos plural
noun_p_f(noun_p_f(lagrimas)) --> [lagrimas].
noun_p_f(noun_p_f(meninas))  --> [meninas].

% nomes masculinos singular
noun_m(noun_m(tempo))   --> [tempo].
noun_m(noun_m(cacador)) --> [cacador].
noun_m(noun_m(rosto))   --> [rosto].
noun_m(noun_m(rio))     --> [rio].
noun_m(noun_m(mar))     --> [mar].
noun_m(noun_m(vento))   --> [vento].
noun_m(noun_m(martelo)) --> [martelo].
noun_m(noun_m(cachorro))--> [cachorro].
noun_m(noun_m(tambor))  --> [tambor].
noun_m(noun_m(sino))    --> [sino].

% nomes masculinos plural
noun_p_m(noun_p_m(lobos))   --> [lobos].
noun_p_m(noun_p_m(tambores))--> [tambores].

% lista das proposicoes
prop(proposition(para)) --> [para].
prop(propostion(com))   --> [com].

% lista das conjuncoes
conjuncao_f(conjuction(pela))   -->[pela].
conjuncao_f(conjuction(na))     -->[na].
conjuncao_m(conjuction(pelo))   -->[pelo].
conjuncao_m(conjuction(no))     -->[no].

conjuncao_p_f(conjuction(pelas))-->[pelas].
conjuncao_p_f(conjuction(nas))  -->[nas].
conjuncao_p_m(conjuction(pelo)) -->[pelo].
conjuncao_p_m(conjuction(no))   -->[no].

% verbos
verb(verb(corre))   --> [corre].
verb(verb(correu))  -->[correu].
verb(verb(bateu))   -->[bateu].
verb(verb(corria))  -->[corria].

verb_p(verb(correm))    --> [correm].
verb_p(verb(correm))    -->[correram].
verb_p(verb(bateram))   -->[bateram].
verb_p(verb(corriam))   -->[corriam].
