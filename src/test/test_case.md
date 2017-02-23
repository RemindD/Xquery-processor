# XPATH
##XPath Expression #1 
doc("j_caesar.xml")//(ACT,PERSONAE)/TITLE 
##XPath Expression #2
doc("j_caesar.xml")//ACT[./TITLE]/*/SPEECH/../TITLE 
##XPath Expression #3
doc("j_caesar.xml")//ACT[./TITLE]/*/SPEECH/../*/.././TITLE 
##XPath Expression #4
doc("j_caesar.xml")//ACT[(./TITLE)==(./TITLE)]/*/SPEECH/../TITLE
##XPath Expression #5
doc("j_caesar.xml")//ACT[not(./TITLE)==(./TITLE)]/*/SPEECH/../TITLE

##XPath Expression #6 for text()
doc("j_caesar.xml")//(ACT,PERSONAE)/TITLE/text()

#XPath Expression #7 for parents of text()
doc("j_caesar.xml")//(ACT,PERSONAE)/TITLE/text()/..

##XPath Expression #7 for attr
doc("j_caesar_attr.xml")//(ACT,PLAY)/TITLE/@date

##XPath Expression #7 for attr's parent
doc("j_caesar_attr.xml")//(ACT,PLAY)/TITLE/@date/..

##XPath Expression #8 for parents null
doc("j_caesar.xml")/PLAY/../../..


#XQuery

###XQuery Expression #1 for xqvar, xqstring, xqtag, xqparen, xqap, xqconcat, xqslash, xqdoubleslash
<acts> 
 {	for $a in doc("j_caesar.xml")//ACT, $b in $a//TITLE
where empty ( for $sp in $a/SCENE/SPEECH/SPEAKER
 where $sp/text() = "CASCA"
   return <speaker> {$sp/text()}</speaker>
     )
     return <act>{$b/text()}</act>
        }
</acts>

###XQuery Expression #2 for let clause, xqlet
<acts> 
 {	for $a in doc("j_caesar.xml")//ACT
  let $b := $a/TITLE
where empty ( for $sp in $a/SCENE/SPEECH/SPEAKER
 where $sp/text() = "CASCA"
   return <speaker> {$sp/text()}</speaker>
     )
     return <act>{$b/text()}</act>
        }
</acts>

###XQuery Expression #3 for some clause
<acts> 
 {	for $a in doc("j_caesar.xml")//ACT
    where some $c in $a/TITLE satisfies $c/text() = "ACT II" or $c/text() = "ACT I"
     return <act>{$c/text()}</act>
        }
</acts>


