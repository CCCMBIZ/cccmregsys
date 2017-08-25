/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/* This script and many more are available free online at
 * The JavaScript Source!! http://javascript.internet.com
 * Created by: Sandeep Gangadharan | http://www.sivamdesign.com/scripts/ 
 */

function changer(link) {

    if (link=="") {
        return;
    }

    //======================
    // Edit this portion below. For each new state copy and paste
    // the entire IF statement and change the name of the state and the cities.
    // Make sure the spelling of the state is the same in the IF statement and in the link.
    if (link=="Illinois") {
        document.step1.theState.value="Illinois";
        var theOptions=new Array (
            	"BOL	靈糧堂	Bread of Life Church",
		"Champaign CCC	香檳華人基督教會	Champaign Chinese Christian Church",
		"CCBC	芝城華人浸信會	Chicago Chinese Baptist Church",
		"CNSCCC	西北教會	Chicago Northwest Suburban Chinese Christian Church",
		"CBCNWS	西北郊華人浸信會	Chinese Baptist Church of Northwest Suburbs",
		"CBCOP	中華友愛教會	Chinese Bible Church of Oak Park",
		"CBC Springfield	春田華人聖經教會	Chinese Bible Church of Springfield",
		"CCFC-SL	芝北教會-南湖堂	Chinese Christian Fellowship Church - South Lake",
		"CCFC-W	芝北教會-本堂	Chinese Christian Fellowship Church - Wilmette",
		"CCMC	國語教會	Chinese Christian Mandarin Church",
		"CCUC-C	聯合會粵語堂	Chinese Christian Union Church - Cantonese",
		"CCUC-E	聯合會英語堂	Chinese Christian Union Church - English",
		"CCUC-M	聯合會國語堂	Chinese Christian Union Church - Mandarin",
		"CCUC-N(C)	聯合會北郊堂-粤	Chinese Christian Union Church - North(C)",
		"CCUC-N(M)	聯合會北郊堂-國	Chinese Christian Union Church - North(M)",
		"CCUC-S	聯合會城南堂	Chinese Christian Union Church - South",
		"CCUC-W		聯合會西郊分會	Chinese Christian Union Church - West",
		"CEFC	華人播道會	Chinese Evangelical Free Church of Greater Chicago",
		"Word	聖道基督教會	Chinese Word Ministries",
		"CCOB	Christ Church of Oak Brook	Christ Church of Oak Brook",
		"CASC	芝城華人基督教會	Christian Assembly of Suburban Chicago",
		"CLPI	生命季刊	Christian Life Press Inc.",
		"CAL	豐盛生命堂	Church of Abundant Life",
		"CCW	College Church - Wheaton	College Church - Wheaton",
		"DCBSG	迪城中文查經班	DeKalb Chinese Bible Study Group",
		"EGBC	EGB Church	Elk Grove Baptist Church",
		"EFCC	芝加哥台福教會	Evangelical Formosan Church of Chicago",
		"ELCC	永生基督教會		Eternal Life Christian Church",
		"EvF Intl			Evangelical Free International Chruch",
		"ETC	芝城三一福音教會	Evangelical Trinity Church in Metro Chicago",
		"FABC	Faith Allicance Bible Church	Faith Alliance Bible Church",
		"FY	福源團契	Fuyuan Fellowship",
		"Feiyang	飛揚團契	Feiyang Fellowship",
		"ACC-UICCCF	天悦团契",
		"GCCC	懷恩堂	Grace Chinese Christian Church",
		"GLC	主恩堂	Grace Lutheran Church",
		"GP	Grace Pointe Church	Grace Pointe Church",
		"GurneeCCC	葛霓華人基督教會	Gurnee Chinese Christian Church",
		"HLCCC	聖光華人基督教會	Holy Light Chinese Christian Church - Bloomington",
		"HPCRC	海德園長老會	Hyde Park Christian Reformed Church",
		"LWEC	活水福音教會	Living Water Evangelical Church",
		"MBI	慕迪聖經學院	Moody Bible Institute",
		"NLCCC	新光堂	New Light Chinese Christian Church",
		"NSCCC-D	城北教會	North Shore Chinese Christian Church - Deerfield",
		"NCCF	西北大學查經班	Northwest Chinese Christian Fellowship",
		"PLC	平安堂	Peace Lutheran Church",
		"Peoria CCC	碧城華人基督教會	Peoria Chinese Christian Church",
		"PTC	培德中心	Pui Tak Center",
		"RCCC	洛城中華基督教會	Rockford Chinese Christian Church",
		"SSCC	南郊華人教會	South Suburban Chinese Church",
		"TEU	三一大學	Trinity Evangelical University",
		"TLLC	真光堂	True Light Lutheran Christian Church",
		"TLC	真理堂	Truth Lutheran Church",
		"WCAC(C)	惠頓宣道會-粤	Wheaton Chinese Alliance Church (C)",
		"WCAC(M)	惠頓宣道會-國	Wheaton Chinese Alliance Church (M)",
		"			Willow Creek Community Church - Chinese Fellowship",
		"		Harvest Bible Chapel",
		"CCLF		香檳主爱团契		Champaign Christ Love Fellowship",
		"CCF,UC		芝大华人校园团契		Chinese Christian Fellowship U of Chicago",
		"OEFC	The Orchard Evangelical Free Church",
		"Other"); 
        var theValues=new Array (
            	"18",
		"36",
		"27",
		"10",
		"23",
		"13",
		"38",
		"5",
		"4",
		"6",
		"25",
		"8",
		"1",
		"26",
		"3",
		"21",
		"2",
		"22",
		"45",
		"39",
		"17",
		"132",
		"46",
		"160",
		"33",
		"115",
		"31",
		"47",
		"105",
		"32",
		"41",
		"113",
		"114",
		"48",
		"28",
		"30",
		"40",
		"42",
		"35",
		"14",
		"7",
		"142",
		"12",
		"15",
		"103",
		"29",
		"37",
		"123",
		"34",
		"16",
		"143",
		"11",
		"9",
		"20",
		"24",
		"104",
		"145",
		"146",
		"106",
		"107",
		"888");
    }
    else if (link=="California") {
        document.step1.theState.value="California";
        var theOptions=new Array (
            "EFC-Orange County		柑縣台福(EFC)	Evangelical Formosa Church - Orange County",
            "Other");
	var theValues=new Array (
            	"750",
		"888");
    }
    else if (link=="Iowa") {
        document.step1.theState.value="Iowa";
        var theOptions=new Array (
            	"CCIC		爱城華人基督教會	Chinese Church of Iowa City",
		"CECIIC		爱城華人福音教會	Chinese Evangelical Church in Iowa City",
		"Ames		爱城華人播道會	Chinese Evangelical Free Church of Ames",
		"Des Moines			Des Moines",
		"QCCCC		廣城華人教會	Quad Cities Chinese Christian Church",
		"Other");
	var theValues=new Array (
            	"703",
		"702",
		"705",
		"704",
		"701",
		"888");
    }
    else if (link=="Indiana") {
        document.step1.theState.value="Indiana";
        var theOptions=new Array (
 		"CCM		Munster Chinese Church	Chinese Church in Munster",
		"CCCI		印城華人基督教會	Chinese Community Church of Indianapolis",
		"GLCAC		拉法葉華人宣道會	Greater Lafayette Chinese Alliance Church",
		"MCCC		南湾華人基督教會	Michiana Chinese Christian Church",
		"FSBC		Terre Haute First Baptist Church",
		"BCCC		Bloomington Chinese Christian Church",
		"MCCF		Muncie Chinese Christian Fellowship",
		"VCF	华邦 Valparaiso Christian Fellowship",
		"Other");
	var theValues=new Array (
		"523",
		"508",
		"510",
		"509",
		"526",
		"527",
		"528",
		"529",
		"888");
    }
    else if (link=="Kentucky") {
        document.step1.theState.value="Kentucky";
        var theOptions=new Array (
		"LexingtonCCC		萊城華人基督教會	Lexington Chinese Christian Church",
		"Louisville CCC		路城華人基督教會	Louisville Chinese Christian Church",
            	"Other");
	var theValues=new Array (
		"512",
		"511",
		"888");
    }
    else if (link=="Michigan") {
        document.step1.theState.value="Michigan";
        var theOptions=new Array (
        "AACCC		安城華人基督教會	Ann Arbor Chinese Christian Church",
		"CBC-Farmington Hills		中華聖經教會	Chinese Bible Church",
		"CGC-Livonia		中華福音教會	Chinese Gospel Church",
		"Grand Rapid CCC		大溪華语基督教會	Grand Rapids Chinese Christian Church",
		"Kalamazoo CCC		卡城華人基督教會	Kalamazoo Chinese Christian Church",
		"Lansing CCM		蘭莘華人基督之家	Lansing Chinese Christian Ministry",
		"Detroit CAC		底特律華人宣道會	Metro Detroit Chinese Alliance Church",
		"MDCAC-N		华人宣道会北堂	Metro Detroit Chinese Alliance Church - North",
		"Oakland CC		奧克蘭華人教會	Oakland Chinese Church",
		"Wayne CAC		伟恩华人宣道会	Wayne Chinese Allinace Church",
            	"Other");
	var theValues=new Array (
		"513",
		"515",
		"516",
		"520",
		"518",
		"519",
		"514",
		"525",
		"517",
		"524",
		"888");
    }
    else if (link=="Minnesota") {
        document.step1.theState.value="Minnesota";
        var theOptions=new Array (
		"MNU		明州大學	Minnesota University",
		"Rochester CCC		羅城華人基督教會	Rochester Chinese Christian Church",
		"Twin City CCC		雙城華人基督教會	Twin City Chinese Christian Church",
		"		明州國語基督教會	",
            	"Other");
	var theValues=new Array (
		"144",
		"605",
		"603",
		"604",
		"888");
    }
    else if (link=="Missouri") {
        document.step1.theState.value="Missouri";
        var theOptions=new Array (
		"STL-LCMS		路德會基督之光堂	Light of Christ Lutheran Chinese Mission",
		"STL-LCC		中華循理會恩光堂	Lighthouse Chinese Church",
		"STL-CBC		聖路易華人浸信會	St. Louis Chinese Baptist Church",
		"STL-CCC		聖路易華人基督教會	St. Louis Chinese Christian Church",
		"STL-CGC		聖路易中華福音教會	St. Louis Chinese Gospel Church",
		"STL-CLC		聖路易華人信義會	St. Louis Chinese Lutheran Church",
		"STL-TPC		聖路易台灣基督教長老教會	Taiwanese Presbyteran Church of Greater St. Louis",
            	"Other");
	var theValues=new Array (
		"711",
		"710",
		"707",
		"706",
		"708",
		"709",
		"712",
		"888");
    }
    else if (link=="Ohio") {
        document.step1.theState.value="Ohio";
        var theOptions=new Array (
		"Agape CEC		主爱華人福音教會	Agape Chinese Evangelical Church",
		"Akron CCC		爱城華人基督教會	Akron Chinese Christian Church",
		"Cincinnati CC		辛城華人基督本堂	Cincinnati Chinese Church",
		"Cincinnati CC		辛城華人基督分堂	Cincinnati Chinese Church",
		"Cleveland CCC		克利夫蘭中國教會	Cleveland Chinese Christian Church",
		"Columbus CCC		哥城華人基督教會	Columbus Chinese Christian church",
		"Dayton CCC		德顿華人基督教會	Dayton Chinese Christian Church",
		"Toledo CAC		多麗都華人基督教會	Toledo Chinese Alliance Church",
            	"Other");
	var theValues=new Array (
		"521",
		"506",
		"504",
		"505",
		"501",
		"502",
		"503",
		"507",
		"888");
    }
    else if (link=="Pennsylvania") {
        document.step1.theState.value="Pennsylvania";
        var theOptions=new Array (
		"PCC	Pittsburgh Christian Church",
		"Other");
	var theValues=new Array (
            	"770",
		"888");
    }
    else if (link=="Tennessee") {
        document.step1.theState.value="Tennessee";
        var theOptions=new Array (
		"Memphis MBC		Memphis華人浸信會	Memphis Mandarin Baptist Church (MMBC)",
            	"Other");
	var theValues=new Array (
            	"522",
		"888");
    }
    else if (link=="Texas") {
        document.step1.theState.value="Texas";
        var theOptions=new Array (
		"FBCC		Fort Bend	Fort Bend Community Church, Houston",
		"Other");
	var theValues=new Array (
            	"713",
		"888");
    }
    else if (link=="Wisconsin") {
        document.step1.theState.value="Wisconsin";
        var theOptions=new Array (
		"MadisonCCC		麥城華人教會	Madison Chinese Christian Church",
		"Milwaukee CCC		米城基督教會	Milwaukee Chinese Christian Church",
		"Appleton CCC	福谷华人基督教会 Appleton Chinese Christian Church",
		"Eastbrook	Eastbrook Church",
		"FVCCC 	(福谷) Fox Valley Chinese Christian Church",
		"GMCEFC	Greater Madison Chinese EfC",
	        "Other");
	var theValues=new Array (
		"601",
		"602",
		"606",
		"607",
		"608",
		"609",
		"888");
    }
    else if (link=="North_Carolina") {
        document.step1.theState.value="North Carolina";
        var theOptions=new Array (
		"CCMC	Chinese Christian Mission Church Durham",
		"Other");
	var theValues=new Array (
            	"771",
		"888");
    }
   else if (link=="Other") {
        document.step1.theState.value="Other";
        var theOptions=new Array (
	        "Other");
	var theValues=new Array (
		"888");
    }


    // Do not edit anything below this line:
    //======================

    i = document.step1.churchID.options.length;
    if (i > 0) {
        document.step1.churchID.options.length -= i;
        document.step1.churchID.options[i] = null;
    }

    var theCount=0;
    for (e=0; e<theOptions.length; e++) {
        document.step1.churchID.options[theCount] = new Option();
        document.step1.churchID.options[theCount].text = theOptions[e];
        document.step1.churchID.options[theCount].value = theValues[e];
        theCount=theCount+1;
    }
}

//  NOTE: [document.step1.theState.value] will get you the name of the state,
//  and [document.step1.churchID.value] the name of the city chosen.value] the name of the city chosensen