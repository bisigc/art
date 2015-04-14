
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
        <link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.at("stylesheets/awesome-bootstrap-checkbox.css")),format.raw/*20.84*/("""" rel="stylesheet">
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
                                <a href ng-switch-when="home" class="homeitem" title=""""),format.raw/*44.87*/("""{"""),format.raw/*44.88*/("""{"""),format.raw/*44.89*/("""menui.tooltip"""),format.raw/*44.102*/("""}"""),format.raw/*44.103*/("""}"""),format.raw/*44.104*/("""" ng-click="setMenu(menui.name)"><img ng-src=""""),format.raw/*44.150*/("""{"""),format.raw/*44.151*/("""{"""),format.raw/*44.152*/("""menui.image"""),format.raw/*44.163*/("""}"""),format.raw/*44.164*/("""}"""),format.raw/*44.165*/("""" class="menuimage img-responsive center-block" /></a>
                                <a href ng-switch-default ng-click="setMenu(menui.name)" title=""""),format.raw/*45.97*/("""{"""),format.raw/*45.98*/("""{"""),format.raw/*45.99*/("""menui.tooltip"""),format.raw/*45.112*/("""}"""),format.raw/*45.113*/("""}"""),format.raw/*45.114*/("""">"""),format.raw/*45.116*/("""{"""),format.raw/*45.117*/("""{"""),format.raw/*45.118*/("""menui.fullname"""),format.raw/*45.132*/("""}"""),format.raw/*45.133*/("""}"""),format.raw/*45.134*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="userCtrl.user.loggedin" class="menuItem menuuser" ng-class=""""),format.raw/*49.102*/("""{"""),format.raw/*49.103*/(""" """),format.raw/*49.104*/("""active:isMenuSet('profile.html')"""),format.raw/*49.136*/("""}"""),format.raw/*49.137*/(""""><a href ng-click="setMenu('profile')"><img ng-src=""""),format.raw/*49.190*/("""{"""),format.raw/*49.191*/("""{"""),format.raw/*49.192*/("""userCtrl.user.avatar"""),format.raw/*49.212*/("""}"""),format.raw/*49.213*/("""}"""),format.raw/*49.214*/("""" class="avatar img-circle" /> """),format.raw/*49.245*/("""{"""),format.raw/*49.246*/("""{"""),format.raw/*49.247*/("""userCtrl.user.firstname"""),format.raw/*49.270*/("""}"""),format.raw/*49.271*/("""}"""),format.raw/*49.272*/(""" """),format.raw/*49.273*/("""{"""),format.raw/*49.274*/("""{"""),format.raw/*49.275*/("""userCtrl.user.surname"""),format.raw/*49.296*/("""}"""),format.raw/*49.297*/("""}"""),format.raw/*49.298*/("""</a></li>
                            <li ng-hide="userCtrl.user.loggedin" class="menuItem"><a href ng-click="userCtrl.login()">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin" class="menuItem"><a href ng-click="userCtrl.logout()">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
            </nav>
            
            <div ng-include="_contextPath + menuItem"></div>

        </div> <!-- /container -->
        <notifications-bar class="notifications"></notifications-bar>

    <script type="text/javascript" src=""""),_display_(/*61.42*/routes/*61.48*/.Assets.at("javascripts/libs/jquery-1.11.2.min.js")),format.raw/*61.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*62.42*/routes/*62.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*62.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*63.42*/routes/*63.48*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*63.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*64.42*/routes/*64.48*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*64.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*65.42*/routes/*65.48*/.Assets.at("javascripts/mockdata.js")),format.raw/*65.85*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*66.42*/routes/*66.48*/.Assets.at("javascripts/app.js")),format.raw/*66.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*67.42*/routes/*67.48*/.Assets.at("javascripts/factories.js")),format.raw/*67.86*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*68.42*/routes/*68.48*/.Assets.at("javascripts/config.js")),format.raw/*68.83*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*69.42*/routes/*69.48*/.Assets.at("javascripts/filterdirectives.js")),format.raw/*69.93*/(""""></script>
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
                  DATE: Fri Apr 10 23:03:16 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: a5025bee88de5e8c167291caf938e4a8536daf36
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1558->592|1626->633|1641->639|1709->686|1778->728|1793->734|1855->775|1923->816|1938->822|2011->874|2079->915|2094->921|2149->955|2217->996|2232->1002|2287->1036|2355->1077|2370->1083|2437->1129|2505->1170|2520->1176|2582->1217|2650->1258|2665->1264|2742->1320|2862->1413|2877->1419|2912->1433|3704->2196|3734->2197|3764->2198|3857->2262|3887->2263|4039->2386|4069->2387|4099->2388|4141->2401|4171->2402|4201->2403|4268->2441|4298->2442|4328->2443|4371->2457|4401->2458|4431->2459|4461->2460|4668->2639|4697->2640|4726->2641|4785->2672|4814->2673|4933->2763|4963->2764|4993->2765|5038->2781|5068->2782|5098->2783|5130->2786|5160->2787|5190->2788|5236->2805|5266->2806|5296->2807|5458->2941|5487->2942|5516->2943|5558->2956|5588->2957|5618->2958|5693->3004|5723->3005|5753->3006|5793->3017|5823->3018|5853->3019|6032->3170|6061->3171|6090->3172|6132->3185|6162->3186|6192->3187|6223->3189|6253->3190|6283->3191|6326->3205|6356->3206|6386->3207|6693->3485|6723->3486|6753->3487|6814->3519|6844->3520|6926->3573|6956->3574|6986->3575|7035->3595|7065->3596|7095->3597|7155->3628|7185->3629|7215->3630|7267->3653|7297->3654|7327->3655|7357->3656|7387->3657|7417->3658|7467->3679|7497->3680|7527->3681|8152->4279|8167->4285|8239->4336|8319->4389|8334->4395|8400->4440|8480->4493|8495->4499|8571->4553|8651->4606|8666->4612|8742->4666|8822->4719|8837->4725|8895->4762|8975->4815|8990->4821|9043->4853|9123->4906|9138->4912|9197->4950|9277->5003|9292->5009|9348->5044|9428->5097|9443->5103|9509->5148|9589->5201|9604->5207|9672->5254|9752->5307|9767->5313|9833->5358|9913->5411|9928->5417|10005->5472|10089->5529|10104->5535|10184->5593|10267->5649|10282->5655|10352->5704|10432->5757|10447->5763|10508->5803|10588->5856|10603->5862|10673->5911|10753->5964|10768->5970|10852->6032|10932->6085|10947->6091|11025->6147
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|50->22|50->22|50->22|67->39|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78
                  -- GENERATED --
              */
          