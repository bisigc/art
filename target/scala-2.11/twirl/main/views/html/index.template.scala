
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
        <script type="text/javascript">
            var _contextPath = """"),_display_(/*19.34*/routes/*19.40*/.Assets.at("")),format.raw/*19.54*/("""";
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
                            <li ng-repeat="menui in menuItems" class="menuItem" ng-switch on="menui.type" ng-if="menui.pos === 'left'" ng-class=""""),format.raw/*36.146*/("""{"""),format.raw/*36.147*/(""" """),format.raw/*36.148*/("""active:isMenuSet(menui.name), dropdown:menui.type === 'dropdown'"""),format.raw/*36.212*/("""}"""),format.raw/*36.213*/("""">
                                <a href ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" title=""""),format.raw/*37.121*/("""{"""),format.raw/*37.122*/("""{"""),format.raw/*37.123*/("""menui.tooltip"""),format.raw/*37.136*/("""}"""),format.raw/*37.137*/("""}"""),format.raw/*37.138*/("""" role="button" aria-expanded="false">"""),format.raw/*37.176*/("""{"""),format.raw/*37.177*/("""{"""),format.raw/*37.178*/("""menui.fullname"""),format.raw/*37.192*/("""}"""),format.raw/*37.193*/("""}"""),format.raw/*37.194*/(""" """),format.raw/*37.195*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-class=""""),format.raw/*39.51*/("""{"""),format.raw/*39.52*/(""" """),format.raw/*39.53*/("""active:isMenuSet(submenui.name)"""),format.raw/*39.84*/("""}"""),format.raw/*39.85*/("""" ng-repeat="submenui in menui.subItems"><a href ng-click="setMenu(submenui.name)" title=""""),format.raw/*39.175*/("""{"""),format.raw/*39.176*/("""{"""),format.raw/*39.177*/("""submenui.tooltip"""),format.raw/*39.193*/("""}"""),format.raw/*39.194*/("""}"""),format.raw/*39.195*/("""" >"""),format.raw/*39.198*/("""{"""),format.raw/*39.199*/("""{"""),format.raw/*39.200*/("""submenui.fullname"""),format.raw/*39.217*/("""}"""),format.raw/*39.218*/("""}"""),format.raw/*39.219*/("""</a></li>
                                </ul>
                                <a href ng-switch-when="home" class="homeitem" title=""""),format.raw/*41.87*/("""{"""),format.raw/*41.88*/("""{"""),format.raw/*41.89*/("""menui.tooltip"""),format.raw/*41.102*/("""}"""),format.raw/*41.103*/("""}"""),format.raw/*41.104*/("""" ng-click="setMenu(menui.name)"><img ng-src=""""),format.raw/*41.150*/("""{"""),format.raw/*41.151*/("""{"""),format.raw/*41.152*/("""menui.image"""),format.raw/*41.163*/("""}"""),format.raw/*41.164*/("""}"""),format.raw/*41.165*/("""" class="menuimage" /></a>
                                <a href ng-switch-default ng-click="setMenu(menui.name)" title=""""),format.raw/*42.97*/("""{"""),format.raw/*42.98*/("""{"""),format.raw/*42.99*/("""menui.tooltip"""),format.raw/*42.112*/("""}"""),format.raw/*42.113*/("""}"""),format.raw/*42.114*/("""">"""),format.raw/*42.116*/("""{"""),format.raw/*42.117*/("""{"""),format.raw/*42.118*/("""menui.fullname"""),format.raw/*42.132*/("""}"""),format.raw/*42.133*/("""}"""),format.raw/*42.134*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="userCtrl.user.loggedin"><a href>"""),format.raw/*46.74*/("""{"""),format.raw/*46.75*/("""{"""),format.raw/*46.76*/("""userCtrl.user.name"""),format.raw/*46.94*/("""}"""),format.raw/*46.95*/("""}"""),format.raw/*46.96*/("""</a></li>
                            <li ng-show="userCtrl.user.loggedin"><img ng-src=""""),format.raw/*47.79*/("""{"""),format.raw/*47.80*/("""{"""),format.raw/*47.81*/("""userCtrl.user.avatar"""),format.raw/*47.101*/("""}"""),format.raw/*47.102*/("""}"""),format.raw/*47.103*/("""" height="40px" /></li>
                            <!-- li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li -->
                            <li ng-show="userCtrl.user.loggedin" ng-class=""""),format.raw/*49.76*/("""{"""),format.raw/*49.77*/(""" """),format.raw/*49.78*/("""active:isMenuSet('profile')"""),format.raw/*49.105*/("""}"""),format.raw/*49.106*/(""""><a href ng-click="setMenu('profile')">Profile</a></li>
                            <li ng-hide="userCtrl.user.loggedin"><a href ng-click="userCtrl.login()">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin"><a href ng-click="userCtrl.logout()">Logout</a></li>
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
    <script type="text/javascript" src=""""),_display_(/*65.42*/routes/*65.48*/.Assets.at("javascripts/app.js")),format.raw/*65.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*66.42*/routes/*66.48*/.Assets.at("javascripts/factories.js")),format.raw/*66.86*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*67.42*/routes/*67.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*67.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*68.42*/routes/*68.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*68.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*69.42*/routes/*69.48*/.Assets.at("javascripts/libs/select.js")),format.raw/*69.88*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*70.42*/routes/*70.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*70.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*71.42*/routes/*71.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*71.110*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*72.42*/routes/*72.48*/.Assets.at("javascripts/libs/ngNotificationsBar.min.js")),format.raw/*72.104*/(""""></script>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Apr 05 19:30:54 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: a19df9c9858f21c4701e2403af3676067dbe925b
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1558->592|1626->633|1641->639|1709->686|1778->728|1793->734|1855->775|1923->816|1938->822|2011->874|2079->915|2094->921|2149->955|2217->996|2232->1002|2287->1036|2407->1129|2422->1135|2457->1149|3249->1912|3279->1913|3309->1914|3402->1978|3432->1979|3584->2102|3614->2103|3644->2104|3686->2117|3716->2118|3746->2119|3813->2157|3843->2158|3873->2159|3916->2173|3946->2174|3976->2175|4006->2176|4213->2355|4242->2356|4271->2357|4330->2388|4359->2389|4478->2479|4508->2480|4538->2481|4583->2497|4613->2498|4643->2499|4675->2502|4705->2503|4735->2504|4781->2521|4811->2522|4841->2523|5003->2657|5032->2658|5061->2659|5103->2672|5133->2673|5163->2674|5238->2720|5268->2721|5298->2722|5338->2733|5368->2734|5398->2735|5549->2858|5578->2859|5607->2860|5649->2873|5679->2874|5709->2875|5740->2877|5770->2878|5800->2879|5843->2893|5873->2894|5903->2895|6181->3145|6210->3146|6239->3147|6285->3165|6314->3166|6343->3167|6459->3255|6488->3256|6517->3257|6566->3277|6596->3278|6626->3279|6876->3501|6905->3502|6934->3503|6990->3530|7020->3531|7658->4142|7673->4148|7745->4199|7825->4252|7840->4258|7906->4303|7986->4356|8001->4362|8077->4416|8157->4469|8172->4475|8248->4529|8328->4582|8343->4588|8396->4620|8476->4673|8491->4679|8550->4717|8630->4770|8645->4776|8713->4823|8793->4876|8808->4882|8874->4927|8954->4980|8969->4986|9030->5026|9110->5079|9125->5085|9195->5134|9275->5187|9290->5193|9374->5255|9454->5308|9469->5314|9547->5370
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|47->19|47->19|47->19|64->36|64->36|64->36|64->36|64->36|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|74->46|74->46|74->46|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|77->49|77->49|77->49|77->49|77->49|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72
                  -- GENERATED --
              */
          