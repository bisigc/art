
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
                            <li ng-repeat="menuItem in menuCtrl.menuItems" class="menuItem" ng-switch on="menuItem.type" ng-if="menuItem.pos === 'left'" ng-class=""""),format.raw/*32.164*/("""{"""),format.raw/*32.165*/(""" """),format.raw/*32.166*/("""active:menuCtrl.isMenuSet(menuItem.name), dropdown:menuItem.type === 'dropdown'"""),format.raw/*32.245*/("""}"""),format.raw/*32.246*/("""">
                                <a href ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" title=""""),format.raw/*33.121*/("""{"""),format.raw/*33.122*/("""{"""),format.raw/*33.123*/("""menuItem.tooltip"""),format.raw/*33.139*/("""}"""),format.raw/*33.140*/("""}"""),format.raw/*33.141*/("""" role="button" aria-expanded="false">"""),format.raw/*33.179*/("""{"""),format.raw/*33.180*/("""{"""),format.raw/*33.181*/("""menuItem.fullname"""),format.raw/*33.198*/("""}"""),format.raw/*33.199*/("""}"""),format.raw/*33.200*/(""" """),format.raw/*33.201*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-class=""""),format.raw/*35.51*/("""{"""),format.raw/*35.52*/(""" """),format.raw/*35.53*/("""active:menuCtrl.isMenuSet(submenuItem.name)"""),format.raw/*35.96*/("""}"""),format.raw/*35.97*/("""" ng-repeat="submenuItem in menuItem.subItems"><a href ng-click="menuCtrl.setMenu(submenuItem.name)" title=""""),format.raw/*35.205*/("""{"""),format.raw/*35.206*/("""{"""),format.raw/*35.207*/("""submenuItem.tooltip"""),format.raw/*35.226*/("""}"""),format.raw/*35.227*/("""}"""),format.raw/*35.228*/("""" >"""),format.raw/*35.231*/("""{"""),format.raw/*35.232*/("""{"""),format.raw/*35.233*/("""submenuItem.fullname"""),format.raw/*35.253*/("""}"""),format.raw/*35.254*/("""}"""),format.raw/*35.255*/("""</a></li>
                                </ul>
                                <a href ng-switch-when="home" class="homeitem" title=""""),format.raw/*37.87*/("""{"""),format.raw/*37.88*/("""{"""),format.raw/*37.89*/("""menuItem.tooltip"""),format.raw/*37.105*/("""}"""),format.raw/*37.106*/("""}"""),format.raw/*37.107*/("""" ng-click="menuCtrl.setMenu(menuItem.name)"><img ng-src=""""),format.raw/*37.165*/("""{"""),format.raw/*37.166*/("""{"""),format.raw/*37.167*/("""menuItem.image"""),format.raw/*37.181*/("""}"""),format.raw/*37.182*/("""}"""),format.raw/*37.183*/("""" class="menuimage" /></a>
                                <a href ng-switch-default ng-click="menuCtrl.setMenu(menuItem.name)" title=""""),format.raw/*38.109*/("""{"""),format.raw/*38.110*/("""{"""),format.raw/*38.111*/("""menuItem.tooltip"""),format.raw/*38.127*/("""}"""),format.raw/*38.128*/("""}"""),format.raw/*38.129*/("""">"""),format.raw/*38.131*/("""{"""),format.raw/*38.132*/("""{"""),format.raw/*38.133*/("""menuItem.fullname"""),format.raw/*38.150*/("""}"""),format.raw/*38.151*/("""}"""),format.raw/*38.152*/("""</a>
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
            </nav>
            
            <div ng-include="menuCtrl.menuItem"></div>

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
                  DATE: Thu Apr 02 16:59:27 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: f56a35a01564ff63254629b1b1b2b49369d2176c
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1558->592|1626->633|1641->639|1709->686|1778->728|1793->734|1855->775|1923->816|1938->822|2011->874|2079->915|2094->921|2149->955|2958->1735|2988->1736|3018->1737|3126->1816|3156->1817|3308->1940|3338->1941|3368->1942|3413->1958|3443->1959|3473->1960|3540->1998|3570->1999|3600->2000|3646->2017|3676->2018|3706->2019|3736->2020|3943->2199|3972->2200|4001->2201|4072->2244|4101->2245|4238->2353|4268->2354|4298->2355|4346->2374|4376->2375|4406->2376|4438->2379|4468->2380|4498->2381|4547->2401|4577->2402|4607->2403|4769->2537|4798->2538|4827->2539|4872->2555|4902->2556|4932->2557|5019->2615|5049->2616|5079->2617|5122->2631|5152->2632|5182->2633|5346->2768|5376->2769|5406->2770|5451->2786|5481->2787|5511->2788|5542->2790|5572->2791|5602->2792|5648->2809|5678->2810|5708->2811|5986->3061|6015->3062|6044->3063|6090->3081|6119->3082|6148->3083|6264->3171|6293->3172|6322->3173|6371->3193|6401->3194|6431->3195|6681->3417|6710->3418|6739->3419|6804->3455|6834->3456|7475->4070|7490->4076|7562->4127|7642->4180|7657->4186|7723->4231|7803->4284|7818->4290|7894->4344|7974->4397|7989->4403|8065->4457|8145->4510|8160->4516|8213->4548|8293->4601|8308->4607|8376->4654|8456->4707|8471->4713|8537->4758|8617->4811|8632->4817|8693->4857|8773->4910|8788->4916|8858->4965|8938->5018|8953->5024|9037->5086|9117->5139|9132->5145|9210->5201
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|60->32|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|70->42|70->42|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|73->45|73->45|73->45|73->45|73->45|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67
                  -- GENERATED --
              */
          