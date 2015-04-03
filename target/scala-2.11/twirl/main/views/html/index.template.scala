
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
                            <li ng-repeat="menui in menuItems" class="menuItem" ng-switch on="menui.type" ng-if="menui.pos === 'left'" ng-class=""""),format.raw/*32.146*/("""{"""),format.raw/*32.147*/(""" """),format.raw/*32.148*/("""active:isMenuSet(menui.name), dropdown:menui.type === 'dropdown'"""),format.raw/*32.212*/("""}"""),format.raw/*32.213*/("""">
                                <a href ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" title=""""),format.raw/*33.121*/("""{"""),format.raw/*33.122*/("""{"""),format.raw/*33.123*/("""menui.tooltip"""),format.raw/*33.136*/("""}"""),format.raw/*33.137*/("""}"""),format.raw/*33.138*/("""" role="button" aria-expanded="false">"""),format.raw/*33.176*/("""{"""),format.raw/*33.177*/("""{"""),format.raw/*33.178*/("""menui.fullname"""),format.raw/*33.192*/("""}"""),format.raw/*33.193*/("""}"""),format.raw/*33.194*/(""" """),format.raw/*33.195*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-class=""""),format.raw/*35.51*/("""{"""),format.raw/*35.52*/(""" """),format.raw/*35.53*/("""active:isMenuSet(submenui.name)"""),format.raw/*35.84*/("""}"""),format.raw/*35.85*/("""" ng-repeat="submenui in menui.subItems"><a href ng-click="setMenu(submenui.name)" title=""""),format.raw/*35.175*/("""{"""),format.raw/*35.176*/("""{"""),format.raw/*35.177*/("""submenui.tooltip"""),format.raw/*35.193*/("""}"""),format.raw/*35.194*/("""}"""),format.raw/*35.195*/("""" >"""),format.raw/*35.198*/("""{"""),format.raw/*35.199*/("""{"""),format.raw/*35.200*/("""submenui.fullname"""),format.raw/*35.217*/("""}"""),format.raw/*35.218*/("""}"""),format.raw/*35.219*/("""</a></li>
                                </ul>
                                <a href ng-switch-when="home" class="homeitem" title=""""),format.raw/*37.87*/("""{"""),format.raw/*37.88*/("""{"""),format.raw/*37.89*/("""menui.tooltip"""),format.raw/*37.102*/("""}"""),format.raw/*37.103*/("""}"""),format.raw/*37.104*/("""" ng-click="setMenu(menui.name)"><img ng-src=""""),format.raw/*37.150*/("""{"""),format.raw/*37.151*/("""{"""),format.raw/*37.152*/("""menui.image"""),format.raw/*37.163*/("""}"""),format.raw/*37.164*/("""}"""),format.raw/*37.165*/("""" class="menuimage" /></a>
                                <a href ng-switch-default ng-click="setMenu(menui.name)" title=""""),format.raw/*38.97*/("""{"""),format.raw/*38.98*/("""{"""),format.raw/*38.99*/("""menui.tooltip"""),format.raw/*38.112*/("""}"""),format.raw/*38.113*/("""}"""),format.raw/*38.114*/("""">"""),format.raw/*38.116*/("""{"""),format.raw/*38.117*/("""{"""),format.raw/*38.118*/("""menui.fullname"""),format.raw/*38.132*/("""}"""),format.raw/*38.133*/("""}"""),format.raw/*38.134*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="userCtrl.user.loggedin"><a href>"""),format.raw/*42.74*/("""{"""),format.raw/*42.75*/("""{"""),format.raw/*42.76*/("""userCtrl.user.name"""),format.raw/*42.94*/("""}"""),format.raw/*42.95*/("""}"""),format.raw/*42.96*/("""</a></li>
                            <li ng-show="userCtrl.user.loggedin"><img ng-src=""""),format.raw/*43.79*/("""{"""),format.raw/*43.80*/("""{"""),format.raw/*43.81*/("""userCtrl.user.avatar"""),format.raw/*43.101*/("""}"""),format.raw/*43.102*/("""}"""),format.raw/*43.103*/("""" height="40px" /></li>
                            <!-- li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li -->
                            <li ng-show="userCtrl.user.loggedin" ng-class=""""),format.raw/*45.76*/("""{"""),format.raw/*45.77*/(""" """),format.raw/*45.78*/("""active:isMenuSet('profile')"""),format.raw/*45.105*/("""}"""),format.raw/*45.106*/(""""><a href ng-click="setMenu('profile')">Profile</a></li>
                            <li ng-hide="userCtrl.user.loggedin"><a href ng-click="userCtrl.login()">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin"><a href ng-click="userCtrl.logout()">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
            </nav>
            
            <div ng-include="menuItem"></div>

        </div> <!-- /container -->
        <notifications-bar class="notifications"></notifications-bar>

    <script type="text/javascript" src=""""),_display_(/*57.42*/routes/*57.48*/.Assets.at("javascripts/libs/jquery-1.11.2.min.js")),format.raw/*57.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*58.42*/routes/*58.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*58.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*59.42*/routes/*59.48*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*59.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*60.42*/routes/*60.48*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*60.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*61.42*/routes/*61.48*/.Assets.at("javascripts/app.js")),format.raw/*61.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*62.42*/routes/*62.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*62.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*63.42*/routes/*63.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*63.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*64.42*/routes/*64.48*/.Assets.at("javascripts/libs/select.js")),format.raw/*64.88*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*65.42*/routes/*65.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*65.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*66.42*/routes/*66.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*66.110*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*67.42*/routes/*67.48*/.Assets.at("javascripts/libs/ngNotificationsBar.min.js")),format.raw/*67.104*/(""""></script>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Apr 03 14:37:25 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: 5638103062d1b3c95a5fd564d4b315cb4f17b562
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1558->592|1626->633|1641->639|1709->686|1778->728|1793->734|1855->775|1923->816|1938->822|2011->874|2079->915|2094->921|2149->955|2940->1717|2970->1718|3000->1719|3093->1783|3123->1784|3275->1907|3305->1908|3335->1909|3377->1922|3407->1923|3437->1924|3504->1962|3534->1963|3564->1964|3607->1978|3637->1979|3667->1980|3697->1981|3904->2160|3933->2161|3962->2162|4021->2193|4050->2194|4169->2284|4199->2285|4229->2286|4274->2302|4304->2303|4334->2304|4366->2307|4396->2308|4426->2309|4472->2326|4502->2327|4532->2328|4694->2462|4723->2463|4752->2464|4794->2477|4824->2478|4854->2479|4929->2525|4959->2526|4989->2527|5029->2538|5059->2539|5089->2540|5240->2663|5269->2664|5298->2665|5340->2678|5370->2679|5400->2680|5431->2682|5461->2683|5491->2684|5534->2698|5564->2699|5594->2700|5872->2950|5901->2951|5930->2952|5976->2970|6005->2971|6034->2972|6150->3060|6179->3061|6208->3062|6257->3082|6287->3083|6317->3084|6567->3306|6596->3307|6625->3308|6681->3335|6711->3336|7334->3932|7349->3938|7421->3989|7501->4042|7516->4048|7582->4093|7662->4146|7677->4152|7753->4206|7833->4259|7848->4265|7924->4319|8004->4372|8019->4378|8072->4410|8152->4463|8167->4469|8235->4516|8315->4569|8330->4575|8396->4620|8476->4673|8491->4679|8552->4719|8632->4772|8647->4778|8717->4827|8797->4880|8812->4886|8896->4948|8976->5001|8991->5007|9069->5063
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|70->42|70->42|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|73->45|73->45|73->45|73->45|73->45|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67
                  -- GENERATED --
              */
          