package ie.gmi.sw.ai;

public class Hobbit {
	
	private String text;
	private String codedText;
	private String key;
	
	public Hobbit(){
		text = "THEHOBBITCHAPTERIANUNEXPECTEDPARTYINAHOLEINTHEGROUNDTHERELIVEDAHOBBITNOTANASTYDIRTYWETHOLEFILLEDWITHTHEENDSOFWORMSANDANOOZYSMELLNORYETADRYBARESANDYHOLEWITHNOTHINGINITTOSITDOWNONORTOEATITWASAHOBBITHOLEANDTHATMEANSCOMFORTITHADAPERFECTLYROUNDDOORLIKEAPORTHOLEPAINTEDGREENWITHASHINYYELLOWBRASSKNOBINTHEEXACTMIDDLETHEDOOROPENEDONTOATUBESHAPEDHALLLIKEATUNNELAVERYCOMFORTABLETUNNELWITHOUTSMOKEWITHPANELLEDWALLSANDFLOORSTILEDANDCARPETEDPROVIDEDWITHPOLISHEDCHAIRSANDLOTSANDLOTSOFPEGSFORHATSANDCOATSTHEHOBBITWASFONDOFVISITORSTHETUNNELWOUNDONANDONGOINGFAIRLYBUTNOTQUITESTRAIGHTINTOTHESIDEOFTHEHILLTHEHILLASALLTHEPEOPLEFORMANYMILESROUNDCALLEDITANDMANYLITTLEROUNDDOORSOPENEDOUTOFITFIRSTONONESIDEANDTHENONANOTHERNOGOINGUPSTAIRSFORTHEHOBBITBEDROOMSBATHROOMSCELLARSPANTRIESLOTSOFTHESEWARDROBESHEHADWHOLEROOMSDEVOTEDTOCLOTHESKITCHENSDININGROOMSALLWEREONTHESAMEFLOORANDINDEEDONTHESAMEPASSAGETHEBESTROOMSWEREALLONTHELEFTHANDSIDEGOINGINFORTHESEWERETHEONLYONESTOHAVEWINDOWSDEEPSETROUNDWINDOWSLOOKINGOVERHISGARDENANDMEADOWSBEYONDSLOPINGDOWNTOTHERIVERTHISHOBBITWASAVERYWELLTODOHOBBITANDHISNAMEWASBAGGINS"
				+ "THEBAGGINSESHADLIVEDINTHENEIGHBOURHOODOFTHEHILLFORTIMEOUTOFMINDANDPEOPLECONSIDEREDTHEMVERYRESPECTABLENOTONLYBECAUSEMOSTOFTHEMWERERICHBUTALSOBECAUSETHEYNEVERHADANYADVENTURESORDIDANYTHINGUNEXPECTEDYOUCOULDTELLWHATABAGGINSWOULDSAYONANYQUESTIONWITHOUTTHEBOTHEROFASKINGHIMTHISISASTORYOFHOWABAGGINSHADANADVENTUREANDFOUNDHIMSELFDOINGANDSAYINGTHINGSALTOGETHERUNEXPECTEDHEMAYHAVELOSTTHENEIGHBOURSRESPECTBUTHEGAINEDWELLYOUWILLSEEWHETHERHEGAINEDANYTHINGINTHEENDTHEMOTHEROFOURPARTICULARHOBBITWHATISAHOBBITISUPPOSEHOBBITSNEEDSOMEDESCRIPTIONNOWADAYSSINCETHEYHAVEBECOMERAREANDSHYOFTHEBIGPEOPLEASTHEYCALLUSTHEYAREORWEREALITTLEPEOPLEABOUTHALFOURHEIGHTANDSMALLERTHANTHEBEARDEDDWARVESHOBBITSHAVENOBEARDSTHEREISLITTLEORNOMAGICABOUTTHEMEXCEPTTHEORDINARYEVERYDAYSORTWHICHHELPSTHEMTODISAPPEARQUIETLYANDQUICKLYWHENLARGESTUPIDFOLKLIKEYOUANDMECOMEBLUNDERINGALONGMAKINGANOISELIKEELEPHANTSWHICHTHEYCANHEARAMILEOFFTHEYAREINCLINEDTOBEFATINTHESTOMACHTHEYDRESSINBRIGHTCOLOURSCHIEFLYGREENANDYELLOWWEARNOSHOESBECAUSETHEIRFEETGROWNATURALLEATHERYSOLESANDTHICKWARMBROWNHAIRLIKETHESTUFFONTHEIRHEADSWHICHISCURLYHAVELONG"
				+ "CLEVERBROWNFINGERSGOODNATUREDFACESANDLAUGHDEEPFRUITYLAUGHSESPECIALLYAFTERDINNERWHICHTHEYHAVETWICEADAYWHENTHEYCANGETITNOWYOUKNOWENOUGHTOGOONWITHASIWASSAYINGTHEMOTHEROFTHISHOBBITOFBILBOBAGGINSTHATISWASTHEFAMOUSBELLADONNATOOKONEOFTHETHREEREMARKABLEDAUGHTERSOFTHEOLDTOOKHEADOFTHEHOBBITSWHOLIVEDACROSSTHEWATERTHESMALLRIVERTHATRANATTHEFOOTOFTHEHILLITWASOFTENSAIDINOTHERFAMILIESTHATLONGAGOONEOFTHETOOKANCESTORSMUSTHAVETAKENAFAIRYWIFETHATWASOFCOURSEABSURDBUTCERTAINLYTHEREWASSTILLSOMETHINGNOTENTIRELYHOBBITLIKEABOUTTHEMANDONCEINAWHILEMEMBERSOFTHETOOKCLANWOULDGOANDHAVEADVENTURESTHEYDISCREETLYDISAPPEAREDANDTHEFAMILYHUSHEDITUPBUTTHEFACTREMAINEDTHATTHETOOKSWERENOTASRESPECTABLEASTHEBAGGINSESTHOUGHTHEYWEREUNDOUBTEDLYRICHERNOTTHATBELLADONNATOOKEVERHADANYADVENTURESAFTERSHEBECAMEMRSBUNGOBAGGINSBUNGOTHATWASBILBOSFATHERBUILTTHEMOSTLUXURIOUSHOBBITHOLEFORHERANDPARTLYWITHHERMONEYTHATWASTOBEFOUNDEITHERUNDERTHEHILLOROVERTHEHILLORACROSSTHEWATERANDTHERETHEYREMAINEDTOTHEENDOFTHEIRDAYSSTILLITISPROBABLETHATBILBOHERONLYSONALTHOUGHHELOOKEDANDBEHAVEDEXACTLYLIKEASECONDEDITIONOFHISSOLIDANDCOMFORTABLEFATHER"
				+ "GOTSOMETHINGABITQUEERINHISMAKEUPFROMTHETOOKSIDESOMETHINGTHATONLYWAITEDFORACHANCETOCOMEOUTTHECHANCENEVERARRIVEDUNTILBILBOBAGGINSWASGROWNUPBEINGABOUTFIFTYYEARSOLDORSOANDLIVINGINTH";
	
		codedText = "HEQEFIRCHITZMHUKOTXEDKWLHKHQVDSIEAKOZTXMTKOEEQSBXTDYHEUKUDBMKYZTFIRCEOMIYOZAEAMKIUZNQHTWDUOBVUDUPNOIEHEQKDLYWXNWILAZDYYOFTWAGADTVUDXXIEKITLKGKSIUYYOYETWDUOCHEFWHEKOABOKHUIMAREMWNFWFWIUNTTIOIOZAZTWFBRCHEXMTYDYHETIDTYOZRMAXWIUOITZMYDHBXHKUMSKXTDYMNXIMRNKZMXIHEXMHDTOOEKYSBQUKDOCHEZATCDEEKVUMXFCISGUYRFWRCOEEQUNZIIAKMVMQHEQMNXIWMKDKYWFIMTIQRUYTZDHPESMVUMRNKTIEXDKMSDQKSIWVOXIITRVQHEXDKPXOITWTHALNIHNOICZYOUDDUPNSMSUYOVNMXXIAURMKYYOPKSIDHHQVDIXMBYKPNOICZXMRAEQPKTZCIAZDYMX"
				+"UAYOVMMIAXWVQYGXXITZUAYOPKMTUAHEQEFIRCHOZAXWDYWXMBARIMXUHEQHEXDKPXXTDYWFYOMNFYMOFYOGCIDSRQEOMIUTOIUYUITOZQIOOEMIEQARYKWXHEQERMMUEQTCVUMSAZVUMUEQDHWMDUXWILYOADRMUYIXEXPKSMDUMKITDYATDEMRHUUMUKXTDYMNXIAXDHDKMNTHWXOIOBXUIMFWDKARYKYOMEEQFWOYFWHEUKFWAFKOSQLZITCIGXXIHEQEFIRCQIKYIXMAGRTIUCFTMAZRUDMSXUMZOEICUYMXUAWXHEUYHNSILKFIUYEQTZPNTWDUIXMAYLQDMIKYIMRPMIEQYROIWCKDYLKOKOSBFTMAAZVUPXUKTNOEEQAZDTXVFTXIYOMKDYQUKYWFHEUYTAHDZAAZYQHEQKUYUIFTMAZXUKTYVUMXOEEQDUOQTZDYARYKAFKOABFX"
				+"XIHEUYHNUKQHEQWFDSWFUYIMTZDQOCDYWNYLQUHDYUUIXTDYOCDYWNUSFTNIKOAFDQCURASZKLKDYOVPTYMNXZKQANDYUSWMKOYVWNOEMIEQICDQIUTCZUFIRCHOZAGMUKZNUDMUNMWTFIRCITDYTCYXTAHNZAIGQBABXYHEQKZSABXYUYTZVMBMKYKOHEKDTKZQIFRXTWNMWXHEQERMVXXIIODTXTIMOVKOMYDYDHWMDUIWXYKMUKKYHETDDQKSKUZLHKITRVKDMIWFDSKQIZRUTDXAIMOQEQPOUKUKCKQCTHSMAXKQIZRUQHEQEDQDUKTZMYDEYMDQOERXUYXIMKMYDEHEKOSQDKWLHKHQYEXTIWRSMEUDPXTZITIGQBABXYNWRS"
				+"LYZGWFYOGETQAUOMFNOITWTHHEQKMIEQIXOGYRKOZQOAHERARAZAIMKSWXTWOZIGQBABXYTZMYOYVLKDHTKUYOVNXTDYTCLAUDNVMOFYYOLYZGKOAQTCFYAZMUFAQHEQXRDKWLHKHQPETDZGTZDQMXAUHEKDTKZQIFRXUXUYDHIHRQHEQYTODKPNUDDSXTOCVUSUQUHNEQHEUKEQSZKOKYYOAETCFYKOHEQUKDMEEQAMHEUKWXXTCLSIIORHMSCUFIRCHOTZIOAZTWFBRCIOURVHMWYUTWFBRCUADKKYAXDTYKZRICMHOMFEFWOZMYGAARWKQHEQZEGMQKHKMAUKSITYDYZUANOQEQRCZVTNDMTYAUEQZKSMSRAUEQGZKUXINHKUSMOIUMHDTNDMTYIFTHTZVXXTCUTKZQITDYALSMDUIUTZOEEQKQSIYKVEPNSIDQZUFIRCUATZDQFWKQSILYHEUKTKUSOIUMTNKXMAZSCKGIXTHUHETDUNKHMHHETNKLKOSIEKDQKSMYGAXIHOTCWCEQMDAUEQAI";
	
		key = "THEQUICKBROWNFXMPDVLAZYGS";
	
	}

	public String getText() {
		return text;
	}
	
	public String getCodedText() {
		return codedText;
	}
	
	public String getKey() {
		return key;
	}
	

}