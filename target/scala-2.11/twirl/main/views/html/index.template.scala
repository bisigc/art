
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="de" ng-app="art">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href=""""),_display_(/*9.33*/routes/*9.39*/.Assets.at("images/favicon.ico")),format.raw/*9.71*/("""">
        <title>Architectural Refactoring Tool</title>
        <link href=""""),_display_(/*11.22*/routes/*11.28*/.Assets.at("stylesheets/bootstrap.min.css")),format.raw/*11.71*/("""" rel="stylesheet">
        <link href=""""),_display_(/*12.22*/routes/*12.28*/.Assets.at("stylesheets/select.css")),format.raw/*12.64*/("""" rel="stylesheet">
        <link href=""""),_display_(/*13.22*/routes/*13.28*/.Assets.at("stylesheets/selectize.default.css")),format.raw/*13.75*/("""" rel="stylesheet" >
        <link href=""""),_display_(/*14.22*/routes/*14.28*/.Assets.at("stylesheets/jqcloud.min.css")),format.raw/*14.69*/("""" rel="stylesheet">
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.at("stylesheets/ngNotificationsBar.min.css")),format.raw/*15.80*/("""" rel="stylesheet">
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.at("stylesheets/main.css")),format.raw/*16.62*/("""" rel="stylesheet">
        <link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.at("stylesheets/tree.css")),format.raw/*17.62*/("""" rel="stylesheet">
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.at("stylesheets/font-awesome.min.css")),format.raw/*18.74*/("""" rel="stylesheet">
        <link href=""""),_display_(/*19.22*/routes/*19.28*/.Assets.at("stylesheets/textAngular.css")),format.raw/*19.69*/("""" rel="stylesheet">
        <link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.at("stylesheets/checkboxsquared.css")),format.raw/*20.73*/("""" rel="stylesheet">
        <script type="text/javascript">
            var _contextPath = """"),_display_(/*22.34*/routes/*22.40*/.Assets.at("")),format.raw/*22.54*/("""";
        </script>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
    </head>

    <body>

        <div class="container" ng-controller="MenuController as menuCtrl">

            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li ng-repeat="menui in menuItems" class="menuItem" ng-switch on="menui.type" ng-if="menui.pos === 'left'" ng-class=""""),format.raw/*39.146*/("""{"""),format.raw/*39.147*/(""" """),format.raw/*39.148*/("""active:isMenuSet(menui.name), dropdown:menui.type === 'dropdown'"""),format.raw/*39.212*/("""}"""),format.raw/*39.213*/("""">
                                <a href ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" title=""""),format.raw/*40.121*/("""{"""),format.raw/*40.122*/("""{"""),format.raw/*40.123*/("""menui.tooltip"""),format.raw/*40.136*/("""}"""),format.raw/*40.137*/("""}"""),format.raw/*40.138*/("""" role="button" aria-expanded="false">"""),format.raw/*40.176*/("""{"""),format.raw/*40.177*/("""{"""),format.raw/*40.178*/("""menui.fullname"""),format.raw/*40.192*/("""}"""),format.raw/*40.193*/("""}"""),format.raw/*40.194*/(""" """),format.raw/*40.195*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-class=""""),format.raw/*42.51*/("""{"""),format.raw/*42.52*/(""" """),format.raw/*42.53*/("""active:isMenuSet(submenui.name)"""),format.raw/*42.84*/("""}"""),format.raw/*42.85*/("""" ng-repeat="submenui in menui.subItems"><a href ng-click="setMenu(submenui.name)" title=""""),format.raw/*42.175*/("""{"""),format.raw/*42.176*/("""{"""),format.raw/*42.177*/("""submenui.tooltip"""),format.raw/*42.193*/("""}"""),format.raw/*42.194*/("""}"""),format.raw/*42.195*/("""" >"""),format.raw/*42.198*/("""{"""),format.raw/*42.199*/("""{"""),format.raw/*42.200*/("""submenui.fullname"""),format.raw/*42.217*/("""}"""),format.raw/*42.218*/("""}"""),format.raw/*42.219*/("""</a></li>
                                </ul>
                                <a href ng-switch-when="home" class="homeitem" title=""""),format.raw/*44.87*/("""{"""),format.raw/*44.88*/("""{"""),format.raw/*44.89*/("""menui.tooltip"""),format.raw/*44.102*/("""}"""),format.raw/*44.103*/("""}"""),format.raw/*44.104*/("""" ng-click="setMenu(menui.name)"><img ng-src=""""),format.raw/*44.150*/("""{"""),format.raw/*44.151*/("""{"""),format.raw/*44.152*/("""menui.image"""),format.raw/*44.163*/("""}"""),format.raw/*44.164*/("""}"""),format.raw/*44.165*/("""" class="menuimage" /></a>
                                <a href ng-switch-default ng-click="setMenu(menui.name)" title=""""),format.raw/*45.97*/("""{"""),format.raw/*45.98*/("""{"""),format.raw/*45.99*/("""menui.tooltip"""),format.raw/*45.112*/("""}"""),format.raw/*45.113*/("""}"""),format.raw/*45.114*/("""">"""),format.raw/*45.116*/("""{"""),format.raw/*45.117*/("""{"""),format.raw/*45.118*/("""menui.fullname"""),format.raw/*45.132*/("""}"""),format.raw/*45.133*/("""}"""),format.raw/*45.134*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="userCtrl.user.loggedin"><a href>"""),format.raw/*49.74*/("""{"""),format.raw/*49.75*/("""{"""),format.raw/*49.76*/("""userCtrl.user.name"""),format.raw/*49.94*/("""}"""),format.raw/*49.95*/("""}"""),format.raw/*49.96*/("""</a></li>
                            <li ng-show="userCtrl.user.loggedin"><img ng-src=""""),format.raw/*50.79*/("""{"""),format.raw/*50.80*/("""{"""),format.raw/*50.81*/("""userCtrl.user.avatar"""),format.raw/*50.101*/("""}"""),format.raw/*50.102*/("""}"""),format.raw/*50.103*/("""" height="40px" /></li>
                            <!-- li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li -->
                            <li ng-show="userCtrl.user.loggedin" ng-class=""""),format.raw/*52.76*/("""{"""),format.raw/*52.77*/(""" """),format.raw/*52.78*/("""active:isMenuSet('profile')"""),format.raw/*52.105*/("""}"""),format.raw/*52.106*/(""""><a href ng-click="setMenu('profile')">Profile</a></li>
                            <li ng-hide="userCtrl.user.loggedin"><a href ng-click="userCtrl.login()">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin"><a href ng-click="userCtrl.logout()">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
            </nav>
            
            <div ng-include="_contextPath + menuItem"></div>

        </div> <!-- /container -->
        <notifications-bar class="notifications"></notifications-bar>

    <script type="text/javascript" src=""""),_display_(/*64.42*/routes/*64.48*/.Assets.at("javascripts/libs/jquery-1.11.2.min.js")),format.raw/*64.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*65.42*/routes/*65.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*65.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*66.42*/routes/*66.48*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*66.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*67.42*/routes/*67.48*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*67.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*68.42*/routes/*68.48*/.Assets.at("javascripts/app.js")),format.raw/*68.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*69.42*/routes/*69.48*/.Assets.at("javascripts/factories.js")),format.raw/*69.86*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*70.42*/routes/*70.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*70.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*71.42*/routes/*71.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*71.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*72.42*/routes/*72.48*/.Assets.at("javascripts/libs/textAngular-rangy.min.js")),format.raw/*72.103*/(""""></script>
    <!-- script type="text/javascript" src=""""),_display_(/*73.46*/routes/*73.52*/.Assets.at("javascripts/libs/textAngular-sanitize.min.js")),format.raw/*73.110*/(""""></script -->
    <script type="text/javascript" src=""""),_display_(/*74.42*/routes/*74.48*/.Assets.at("javascripts/libs/textAngular.min.js")),format.raw/*74.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*75.42*/routes/*75.48*/.Assets.at("javascripts/libs/select.js")),format.raw/*75.88*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*76.42*/routes/*76.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*76.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*77.42*/routes/*77.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*77.110*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*78.42*/routes/*78.48*/.Assets.at("javascripts/libs/ngNotificationsBar.min.js")),format.raw/*78.104*/(""""></script>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Apr 09 18:09:14 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: 44e4814d949f0c9712644749d42ed4b8552bc592
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1558->592|1626->633|1641->639|1709->686|1778->728|1793->734|1855->775|1923->816|1938->822|2011->874|2079->915|2094->921|2149->955|2217->996|2232->1002|2287->1036|2355->1077|2370->1083|2437->1129|2505->1170|2520->1176|2582->1217|2650->1258|2665->1264|2731->1309|2851->1402|2866->1408|2901->1422|3693->2185|3723->2186|3753->2187|3846->2251|3876->2252|4028->2375|4058->2376|4088->2377|4130->2390|4160->2391|4190->2392|4257->2430|4287->2431|4317->2432|4360->2446|4390->2447|4420->2448|4450->2449|4657->2628|4686->2629|4715->2630|4774->2661|4803->2662|4922->2752|4952->2753|4982->2754|5027->2770|5057->2771|5087->2772|5119->2775|5149->2776|5179->2777|5225->2794|5255->2795|5285->2796|5447->2930|5476->2931|5505->2932|5547->2945|5577->2946|5607->2947|5682->2993|5712->2994|5742->2995|5782->3006|5812->3007|5842->3008|5993->3131|6022->3132|6051->3133|6093->3146|6123->3147|6153->3148|6184->3150|6214->3151|6244->3152|6287->3166|6317->3167|6347->3168|6625->3418|6654->3419|6683->3420|6729->3438|6758->3439|6787->3440|6903->3528|6932->3529|6961->3530|7010->3550|7040->3551|7070->3552|7320->3774|7349->3775|7378->3776|7434->3803|7464->3804|8102->4415|8117->4421|8189->4472|8269->4525|8284->4531|8350->4576|8430->4629|8445->4635|8521->4689|8601->4742|8616->4748|8692->4802|8772->4855|8787->4861|8840->4893|8920->4946|8935->4952|8994->4990|9074->5043|9089->5049|9157->5096|9237->5149|9252->5155|9318->5200|9398->5253|9413->5259|9490->5314|9574->5371|9589->5377|9669->5435|9752->5491|9767->5497|9837->5546|9917->5599|9932->5605|9993->5645|10073->5698|10088->5704|10158->5753|10238->5806|10253->5812|10337->5874|10417->5927|10432->5933|10510->5989
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|50->22|50->22|50->22|67->39|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|77->49|77->49|77->49|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|78->50|80->52|80->52|80->52|80->52|80->52|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78
                  -- GENERATED --
              */
          