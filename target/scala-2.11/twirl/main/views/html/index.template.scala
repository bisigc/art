
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(activeProfile: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.25*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="de" ng-app="art">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href=""""),_display_(/*10.33*/routes/*10.39*/.Assets.at("images/favicon.ico")),format.raw/*10.71*/("""">
        <title>Architectural Refactoring Tool</title>
        <link href=""""),_display_(/*12.22*/routes/*12.28*/.Assets.at("stylesheets/bootstrap.min.css")),format.raw/*12.71*/("""" rel="stylesheet">
        <link href=""""),_display_(/*13.22*/routes/*13.28*/.Assets.at("stylesheets/select.css")),format.raw/*13.64*/("""" rel="stylesheet">
        <link href=""""),_display_(/*14.22*/routes/*14.28*/.Assets.at("stylesheets/selectize.default.css")),format.raw/*14.75*/("""" rel="stylesheet" >
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.at("stylesheets/jqcloud.min.css")),format.raw/*15.69*/("""" rel="stylesheet">
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.at("stylesheets/ngNotificationsBar.min.css")),format.raw/*16.80*/("""" rel="stylesheet">
        <link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.at("stylesheets/main.css")),format.raw/*17.62*/("""" rel="stylesheet">
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.at("stylesheets/tree.css")),format.raw/*18.62*/("""" rel="stylesheet">
        <link href=""""),_display_(/*19.22*/routes/*19.28*/.Assets.at("stylesheets/font-awesome.min.css")),format.raw/*19.74*/("""" rel="stylesheet">
        <link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.at("stylesheets/textAngular.css")),format.raw/*20.69*/("""" rel="stylesheet">
        <link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.at("stylesheets/awesome-bootstrap-checkbox.css")),format.raw/*21.84*/("""" rel="stylesheet">
        <script type="text/javascript">
            var _contextPath = """"),_display_(/*23.34*/routes/*23.40*/.Assets.at("")),format.raw/*23.54*/("""";
            var activeProfile = """"),_display_(/*24.35*/activeProfile),format.raw/*24.48*/("""";
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
                            <li ng-repeat="menui in menuItems" class="menuItem" ng-switch on="menui.type" ng-if="menui.pos === 'left'" ng-class=""""),format.raw/*41.146*/("""{"""),format.raw/*41.147*/("""dropdown:menui.type === 'dropdown'"""),format.raw/*41.181*/("""}"""),format.raw/*41.182*/("""">
                                <a ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" title=""""),format.raw/*42.116*/("""{"""),format.raw/*42.117*/("""{"""),format.raw/*42.118*/("""menui.tooltip"""),format.raw/*42.131*/("""}"""),format.raw/*42.132*/("""}"""),format.raw/*42.133*/("""" role="button" aria-expanded="false">"""),format.raw/*42.171*/("""{"""),format.raw/*42.172*/("""{"""),format.raw/*42.173*/("""menui.fullname"""),format.raw/*42.187*/("""}"""),format.raw/*42.188*/("""}"""),format.raw/*42.189*/(""" """),format.raw/*42.190*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-repeat="submenui in menui.subItems"><a ui-sref=""""),format.raw/*44.92*/("""{"""),format.raw/*44.93*/("""{"""),format.raw/*44.94*/("""submenui.name"""),format.raw/*44.107*/("""}"""),format.raw/*44.108*/("""}"""),format.raw/*44.109*/("""" ui-sref-active="active" title=""""),format.raw/*44.142*/("""{"""),format.raw/*44.143*/("""{"""),format.raw/*44.144*/("""submenui.tooltip"""),format.raw/*44.160*/("""}"""),format.raw/*44.161*/("""}"""),format.raw/*44.162*/("""" >"""),format.raw/*44.165*/("""{"""),format.raw/*44.166*/("""{"""),format.raw/*44.167*/("""submenui.fullname"""),format.raw/*44.184*/("""}"""),format.raw/*44.185*/("""}"""),format.raw/*44.186*/("""</a></li>
                                </ul>
                                <a ng-switch-when="home" class="homeitem" title=""""),format.raw/*46.82*/("""{"""),format.raw/*46.83*/("""{"""),format.raw/*46.84*/("""menui.tooltip"""),format.raw/*46.97*/("""}"""),format.raw/*46.98*/("""}"""),format.raw/*46.99*/("""" ui-sref=""""),format.raw/*46.110*/("""{"""),format.raw/*46.111*/("""{"""),format.raw/*46.112*/("""menui.name"""),format.raw/*46.122*/("""}"""),format.raw/*46.123*/("""}"""),format.raw/*46.124*/("""" ui-sref-active="active"><img ng-src=""""),format.raw/*46.163*/("""{"""),format.raw/*46.164*/("""{"""),format.raw/*46.165*/("""menui.image"""),format.raw/*46.176*/("""}"""),format.raw/*46.177*/("""}"""),format.raw/*46.178*/("""" class="menuimage img-responsive center-block" /></a>
                                <!-- a href ng-switch-default ng-click="setMenu(menui.name)" title=""""),format.raw/*47.101*/("""{"""),format.raw/*47.102*/("""{"""),format.raw/*47.103*/("""menui.tooltip"""),format.raw/*47.116*/("""}"""),format.raw/*47.117*/("""}"""),format.raw/*47.118*/("""">"""),format.raw/*47.120*/("""{"""),format.raw/*47.121*/("""{"""),format.raw/*47.122*/("""menui.fullname"""),format.raw/*47.136*/("""}"""),format.raw/*47.137*/("""}"""),format.raw/*47.138*/("""</a-->
                                <a ng-switch-default ui-sref=""""),format.raw/*48.63*/("""{"""),format.raw/*48.64*/("""{"""),format.raw/*48.65*/("""menui.name"""),format.raw/*48.75*/("""}"""),format.raw/*48.76*/("""}"""),format.raw/*48.77*/("""" ui-sref-active="active" title=""""),format.raw/*48.110*/("""{"""),format.raw/*48.111*/("""{"""),format.raw/*48.112*/("""menui.tooltip"""),format.raw/*48.125*/("""}"""),format.raw/*48.126*/("""}"""),format.raw/*48.127*/("""">"""),format.raw/*48.129*/("""{"""),format.raw/*48.130*/("""{"""),format.raw/*48.131*/("""menui.fullname"""),format.raw/*48.145*/("""}"""),format.raw/*48.146*/("""}"""),format.raw/*48.147*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="isLoggedin()" class="menuItem menuuser"><a ui-sref="profile"  ui-sref-active="active"><img ng-src=""""),format.raw/*52.141*/("""{"""),format.raw/*52.142*/("""{"""),format.raw/*52.143*/("""currentUser.profile.avatar"""),format.raw/*52.169*/("""}"""),format.raw/*52.170*/("""}"""),format.raw/*52.171*/("""" class="avatar img-circle" /> """),format.raw/*52.202*/("""{"""),format.raw/*52.203*/("""{"""),format.raw/*52.204*/("""currentUser.profile.firstname"""),format.raw/*52.233*/("""}"""),format.raw/*52.234*/("""}"""),format.raw/*52.235*/(""" """),format.raw/*52.236*/("""{"""),format.raw/*52.237*/("""{"""),format.raw/*52.238*/("""currentUser.profile.lastname"""),format.raw/*52.266*/("""}"""),format.raw/*52.267*/("""}"""),format.raw/*52.268*/("""</a></li>
                            <li ng-hide="isLoggedin()" class="menuItem dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" title="Login" role="button" aria-expanded="false">Login <span class="caret"></span></a>
                                <ul class="dropdown-menu login-dropdown" role="menu">
                                    <li><div ng-include="_contextPath + 'login.html'"></div></li>
                                </ul>
                            </li>
                            <li ng-show="isLoggedin()" class="menuItem"><a href ng-click="logout()">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
            </nav>
            
            <div ui-view></div>
            <!-- div ng-include="_contextPath + menuItem"></div -->

        </div> <!-- /container -->
        <notifications-bar class="notifications"></notifications-bar>

    <script type="text/javascript" src=""""),_display_(/*70.42*/routes/*70.48*/.Assets.at("javascripts/libs/jquery-1.11.2.min.js")),format.raw/*70.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*71.42*/routes/*71.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*71.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*72.42*/routes/*72.48*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*72.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*73.42*/routes/*73.48*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*73.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*74.42*/routes/*74.48*/.Assets.at("javascripts/libs/angular-ui-router.min.js")),format.raw/*74.103*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*75.42*/routes/*75.48*/.Assets.at("javascripts/mockdata.js")),format.raw/*75.85*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*76.42*/routes/*76.48*/.Assets.at("javascripts/app.js")),format.raw/*76.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*77.42*/routes/*77.48*/.Assets.at("javascripts/factories.js")),format.raw/*77.86*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*78.42*/routes/*78.48*/.Assets.at("javascripts/config.js")),format.raw/*78.83*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*79.42*/routes/*79.48*/.Assets.at("javascripts/filterdirectives.js")),format.raw/*79.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*80.42*/routes/*80.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*80.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*81.42*/routes/*81.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*81.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*82.42*/routes/*82.48*/.Assets.at("javascripts/libs/textAngular-rangy.min.js")),format.raw/*82.103*/(""""></script>
    <!-- script type="text/javascript" src=""""),_display_(/*83.46*/routes/*83.52*/.Assets.at("javascripts/libs/textAngular-sanitize.min.js")),format.raw/*83.110*/(""""></script -->
    <script type="text/javascript" src=""""),_display_(/*84.42*/routes/*84.48*/.Assets.at("javascripts/libs/textAngular.min.js")),format.raw/*84.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*85.42*/routes/*85.48*/.Assets.at("javascripts/libs/select.js")),format.raw/*85.88*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*86.42*/routes/*86.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*86.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*87.42*/routes/*87.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*87.110*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*88.42*/routes/*88.48*/.Assets.at("javascripts/libs/ngNotificationsBar.min.js")),format.raw/*88.104*/(""""></script>
    </body>
</html>"""))}
  }

  def render(activeProfile:String): play.twirl.api.HtmlFormat.Appendable = apply(activeProfile)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (activeProfile) => apply(activeProfile)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Apr 23 17:07:33 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: f39c3c96456c9b4121c880752bbf0b97eaabedc6
                  MATRIX: 723->1|834->24|861->25|1232->369|1247->375|1300->407|1405->485|1420->491|1484->534|1552->575|1567->581|1624->617|1692->658|1707->664|1775->711|1844->753|1859->759|1921->800|1989->841|2004->847|2077->899|2145->940|2160->946|2215->980|2283->1021|2298->1027|2353->1061|2421->1102|2436->1108|2503->1154|2571->1195|2586->1201|2648->1242|2716->1283|2731->1289|2808->1345|2928->1438|2943->1444|2978->1458|3042->1495|3076->1508|3868->2271|3898->2272|3961->2306|3991->2307|4138->2425|4168->2426|4198->2427|4240->2440|4270->2441|4300->2442|4367->2480|4397->2481|4427->2482|4470->2496|4500->2497|4530->2498|4560->2499|4808->2719|4837->2720|4866->2721|4908->2734|4938->2735|4968->2736|5030->2769|5060->2770|5090->2771|5135->2787|5165->2788|5195->2789|5227->2792|5257->2793|5287->2794|5333->2811|5363->2812|5393->2813|5550->2942|5579->2943|5608->2944|5649->2957|5678->2958|5707->2959|5747->2970|5777->2971|5807->2972|5846->2982|5876->2983|5906->2984|5974->3023|6004->3024|6034->3025|6074->3036|6104->3037|6134->3038|6318->3193|6348->3194|6378->3195|6420->3208|6450->3209|6480->3210|6511->3212|6541->3213|6571->3214|6614->3228|6644->3229|6674->3230|6771->3299|6800->3300|6829->3301|6867->3311|6896->3312|6925->3313|6987->3346|7017->3347|7047->3348|7089->3361|7119->3362|7149->3363|7180->3365|7210->3366|7240->3367|7283->3381|7313->3382|7343->3383|7689->3700|7719->3701|7749->3702|7804->3728|7834->3729|7864->3730|7924->3761|7954->3762|7984->3763|8042->3792|8072->3793|8102->3794|8132->3795|8162->3796|8192->3797|8249->3825|8279->3826|8309->3827|9329->4820|9344->4826|9416->4877|9496->4930|9511->4936|9577->4981|9657->5034|9672->5040|9748->5094|9828->5147|9843->5153|9919->5207|9999->5260|10014->5266|10091->5321|10171->5374|10186->5380|10244->5417|10324->5470|10339->5476|10392->5508|10472->5561|10487->5567|10546->5605|10626->5658|10641->5664|10697->5699|10777->5752|10792->5758|10858->5803|10938->5856|10953->5862|11021->5909|11101->5962|11116->5968|11182->6013|11262->6066|11277->6072|11354->6127|11438->6184|11453->6190|11533->6248|11616->6304|11631->6310|11701->6359|11781->6412|11796->6418|11857->6458|11937->6511|11952->6517|12022->6566|12102->6619|12117->6625|12201->6687|12281->6740|12296->6746|12374->6802
                  LINES: 26->1|29->1|30->2|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|51->23|51->23|51->23|52->24|52->24|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|111->83|111->83|111->83|112->84|112->84|112->84|113->85|113->85|113->85|114->86|114->86|114->86|115->87|115->87|115->87|116->88|116->88|116->88
                  -- GENERATED --
              */
          