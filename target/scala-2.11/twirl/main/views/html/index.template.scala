
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
        <link href=""""),_display_(/*12.22*/routes/*12.28*/.Assets.at("stylesheets/main.css")),format.raw/*12.62*/("""" rel="stylesheet">
        <link href=""""),_display_(/*13.22*/routes/*13.28*/.Assets.at("stylesheets/select.css")),format.raw/*13.64*/("""" rel="stylesheet">
          <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.8.5/css/selectize.default.css">
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.at("stylesheets/jqcloud.min.css")),format.raw/*15.69*/("""" rel="stylesheet">
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
                <div class="container">
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li ng-repeat="menuItem in menuCtrl.menuItems" class="menuItem" ng-switch on="menuItem.type" ng-if="menuItem.pos === 'left'" ng-class=""""),format.raw/*32.164*/("""{"""),format.raw/*32.165*/(""" """),format.raw/*32.166*/("""active:menuCtrl.isMenuSet(menuItem.name), dropdown:menuItem.type === 'dropdown'"""),format.raw/*32.245*/("""}"""),format.raw/*32.246*/("""">
                                <a href ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">"""),format.raw/*33.150*/("""{"""),format.raw/*33.151*/("""{"""),format.raw/*33.152*/("""menuItem.fullname"""),format.raw/*33.169*/("""}"""),format.raw/*33.170*/("""}"""),format.raw/*33.171*/(""" """),format.raw/*33.172*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-class=""""),format.raw/*35.51*/("""{"""),format.raw/*35.52*/(""" """),format.raw/*35.53*/("""active:menuCtrl.isMenuSet(submenuItem.name)"""),format.raw/*35.96*/("""}"""),format.raw/*35.97*/("""" ng-repeat="submenuItem in menuItem.subItems"><a href ng-click="menuCtrl.setMenu(submenuItem.name)">"""),format.raw/*35.198*/("""{"""),format.raw/*35.199*/("""{"""),format.raw/*35.200*/("""submenuItem.fullname"""),format.raw/*35.220*/("""}"""),format.raw/*35.221*/("""}"""),format.raw/*35.222*/("""</a></li>
                                </ul>
                                <a href ng-switch-when="home" class="homeitem" ng-click="menuCtrl.setMenu(menuItem.name)"><img ng-src=""""),format.raw/*37.136*/("""{"""),format.raw/*37.137*/("""{"""),format.raw/*37.138*/("""menuItem.image"""),format.raw/*37.152*/("""}"""),format.raw/*37.153*/("""}"""),format.raw/*37.154*/("""" /></a>
                                <a href ng-switch-default ng-click="menuCtrl.setMenu(menuItem.name)">"""),format.raw/*38.102*/("""{"""),format.raw/*38.103*/("""{"""),format.raw/*38.104*/("""menuItem.fullname"""),format.raw/*38.121*/("""}"""),format.raw/*38.122*/("""}"""),format.raw/*38.123*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="userCtrl.user.loggedin"><a href>"""),format.raw/*42.74*/("""{"""),format.raw/*42.75*/("""{"""),format.raw/*42.76*/("""userCtrl.user.name"""),format.raw/*42.94*/("""}"""),format.raw/*42.95*/("""}"""),format.raw/*42.96*/("""</a></li>
                            <li ng-show="userCtrl.user.loggedin"><img ng-src=""""),format.raw/*43.79*/("""{"""),format.raw/*43.80*/("""{"""),format.raw/*43.81*/("""userCtrl.user.avatar"""),format.raw/*43.101*/("""}"""),format.raw/*43.102*/("""}"""),format.raw/*43.103*/("""" height="40px" /></li>
                            <!-- li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li -->
                            <li ng-show="userCtrl.user.loggedin" ng-class=""""),format.raw/*45.76*/("""{"""),format.raw/*45.77*/(""" """),format.raw/*45.78*/("""active:menuCtrl.isMenuSet('profile')"""),format.raw/*45.114*/("""}"""),format.raw/*45.115*/(""""><a href ng-click="menuCtrl.setMenu('profile')">Profile</a></li>
                            <li ng-hide="userCtrl.user.loggedin"><a href ng-click="userCtrl.login()">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin"><a href ng-click="userCtrl.logout()">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </nav>
            
            <div ng-include="menuCtrl.menuItem"></div>

        </div> <!-- /container -->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src=""""),_display_(/*58.42*/routes/*58.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*58.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*59.42*/routes/*59.48*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*59.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*60.42*/routes/*60.48*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*60.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*61.42*/routes/*61.48*/.Assets.at("javascripts/app.js")),format.raw/*61.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*62.42*/routes/*62.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*62.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*63.42*/routes/*63.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*63.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*64.42*/routes/*64.48*/.Assets.at("javascripts/libs/select.js")),format.raw/*64.88*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*65.42*/routes/*65.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*65.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*66.42*/routes/*66.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*66.110*/(""""></script>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Mar 26 16:24:01 CET 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: 44b36c83088741b425be95dfd73bb48d2c592099
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1556->590|1624->631|1639->637|1696->673|1888->838|1903->844|1965->885|2814->1705|2844->1706|2874->1707|2982->1786|3012->1787|3193->1939|3223->1940|3253->1941|3299->1958|3329->1959|3359->1960|3389->1961|3596->2140|3625->2141|3654->2142|3725->2185|3754->2186|3884->2287|3914->2288|3944->2289|3993->2309|4023->2310|4053->2311|4265->2494|4295->2495|4325->2496|4368->2510|4398->2511|4428->2512|4567->2622|4597->2623|4627->2624|4673->2641|4703->2642|4733->2643|5011->2893|5040->2894|5069->2895|5115->2913|5144->2914|5173->2915|5289->3003|5318->3004|5347->3005|5396->3025|5426->3026|5456->3027|5706->3249|5735->3250|5764->3251|5829->3287|5859->3288|6547->3949|6562->3955|6628->4000|6708->4053|6723->4059|6799->4113|6879->4166|6894->4172|6970->4226|7050->4279|7065->4285|7118->4317|7198->4370|7213->4376|7281->4423|7361->4476|7376->4482|7442->4527|7522->4580|7537->4586|7598->4626|7678->4679|7693->4685|7763->4734|7843->4787|7858->4793|7942->4855
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|43->15|43->15|43->15|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|61->33|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|66->38|66->38|66->38|70->42|70->42|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|73->45|73->45|73->45|73->45|73->45|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66
                  -- GENERATED --
              */
          