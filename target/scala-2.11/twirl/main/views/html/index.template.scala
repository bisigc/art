
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
                            <li ng-repeat="menui in menuItems" class="menuItem" ng-switch on="menui.type" ng-if="menui.pos === 'left'" ng-class=""""),format.raw/*41.146*/("""{"""),format.raw/*41.147*/("""dropdown:menui.type === 'dropdown', active:$state.is(menui.name)"""),format.raw/*41.211*/("""}"""),format.raw/*41.212*/("""">
                                <a ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" title=""""),format.raw/*42.116*/("""{"""),format.raw/*42.117*/("""{"""),format.raw/*42.118*/("""menui.tooltip"""),format.raw/*42.131*/("""}"""),format.raw/*42.132*/("""}"""),format.raw/*42.133*/("""" role="button" aria-expanded="false">"""),format.raw/*42.171*/("""{"""),format.raw/*42.172*/("""{"""),format.raw/*42.173*/("""menui.fullname"""),format.raw/*42.187*/("""}"""),format.raw/*42.188*/("""}"""),format.raw/*42.189*/(""" """),format.raw/*42.190*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-repeat="submenui in menui.subItems"><a ui-sref=""""),format.raw/*44.92*/("""{"""),format.raw/*44.93*/("""{"""),format.raw/*44.94*/("""submenui.name"""),format.raw/*44.107*/("""}"""),format.raw/*44.108*/("""}"""),format.raw/*44.109*/("""" title=""""),format.raw/*44.118*/("""{"""),format.raw/*44.119*/("""{"""),format.raw/*44.120*/("""submenui.tooltip"""),format.raw/*44.136*/("""}"""),format.raw/*44.137*/("""}"""),format.raw/*44.138*/("""" >"""),format.raw/*44.141*/("""{"""),format.raw/*44.142*/("""{"""),format.raw/*44.143*/("""submenui.fullname"""),format.raw/*44.160*/("""}"""),format.raw/*44.161*/("""}"""),format.raw/*44.162*/("""</a></li>
                                </ul>
                                <a ng-switch-when="home" class="homeitem" title=""""),format.raw/*46.82*/("""{"""),format.raw/*46.83*/("""{"""),format.raw/*46.84*/("""menui.tooltip"""),format.raw/*46.97*/("""}"""),format.raw/*46.98*/("""}"""),format.raw/*46.99*/("""" ui-sref=""""),format.raw/*46.110*/("""{"""),format.raw/*46.111*/("""{"""),format.raw/*46.112*/("""menui.name"""),format.raw/*46.122*/("""}"""),format.raw/*46.123*/("""}"""),format.raw/*46.124*/(""""><img ng-src=""""),format.raw/*46.139*/("""{"""),format.raw/*46.140*/("""{"""),format.raw/*46.141*/("""menui.image"""),format.raw/*46.152*/("""}"""),format.raw/*46.153*/("""}"""),format.raw/*46.154*/("""" class="menuimage img-responsive center-block" /></a>
                                <!-- a href ng-switch-default ng-click="setMenu(menui.name)" title=""""),format.raw/*47.101*/("""{"""),format.raw/*47.102*/("""{"""),format.raw/*47.103*/("""menui.tooltip"""),format.raw/*47.116*/("""}"""),format.raw/*47.117*/("""}"""),format.raw/*47.118*/("""">"""),format.raw/*47.120*/("""{"""),format.raw/*47.121*/("""{"""),format.raw/*47.122*/("""menui.fullname"""),format.raw/*47.136*/("""}"""),format.raw/*47.137*/("""}"""),format.raw/*47.138*/("""</a-->
                                <a ng-switch-default ui-sref=""""),format.raw/*48.63*/("""{"""),format.raw/*48.64*/("""{"""),format.raw/*48.65*/("""menui.name"""),format.raw/*48.75*/("""}"""),format.raw/*48.76*/("""}"""),format.raw/*48.77*/("""" title=""""),format.raw/*48.86*/("""{"""),format.raw/*48.87*/("""{"""),format.raw/*48.88*/("""menui.tooltip"""),format.raw/*48.101*/("""}"""),format.raw/*48.102*/("""}"""),format.raw/*48.103*/("""">"""),format.raw/*48.105*/("""{"""),format.raw/*48.106*/("""{"""),format.raw/*48.107*/("""menui.fullname"""),format.raw/*48.121*/("""}"""),format.raw/*48.122*/("""}"""),format.raw/*48.123*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="isLoggedin()" class="menuItem menuuser" ng-class=""""),format.raw/*52.92*/("""{"""),format.raw/*52.93*/("""active:$state.is('profile')"""),format.raw/*52.120*/("""}"""),format.raw/*52.121*/(""""><a ui-sref="profile"><img ng-src=""""),format.raw/*52.157*/("""{"""),format.raw/*52.158*/("""{"""),format.raw/*52.159*/("""currentUser.profile.avatar"""),format.raw/*52.185*/("""}"""),format.raw/*52.186*/("""}"""),format.raw/*52.187*/("""" class="avatar img-circle" /> """),format.raw/*52.218*/("""{"""),format.raw/*52.219*/("""{"""),format.raw/*52.220*/("""currentUser.profile.firstname"""),format.raw/*52.249*/("""}"""),format.raw/*52.250*/("""}"""),format.raw/*52.251*/(""" """),format.raw/*52.252*/("""{"""),format.raw/*52.253*/("""{"""),format.raw/*52.254*/("""currentUser.profile.lastname"""),format.raw/*52.282*/("""}"""),format.raw/*52.283*/("""}"""),format.raw/*52.284*/("""</a></li>
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
                  DATE: Tue Apr 28 00:49:24 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: 1519ccf57f74a4596bf248b34dbe1e6a85ca219e
                  MATRIX: 723->1|834->24|861->25|1232->369|1247->375|1300->407|1405->485|1420->491|1484->534|1552->575|1567->581|1624->617|1692->658|1707->664|1775->711|1844->753|1859->759|1921->800|1989->841|2004->847|2077->899|2145->940|2160->946|2215->980|2283->1021|2298->1027|2353->1061|2421->1102|2436->1108|2503->1154|2571->1195|2586->1201|2648->1242|2716->1283|2731->1289|2808->1345|2928->1438|2943->1444|2978->1458|3042->1495|3076->1508|3868->2271|3898->2272|3991->2336|4021->2337|4168->2455|4198->2456|4228->2457|4270->2470|4300->2471|4330->2472|4397->2510|4427->2511|4457->2512|4500->2526|4530->2527|4560->2528|4590->2529|4838->2749|4867->2750|4896->2751|4938->2764|4968->2765|4998->2766|5036->2775|5066->2776|5096->2777|5141->2793|5171->2794|5201->2795|5233->2798|5263->2799|5293->2800|5339->2817|5369->2818|5399->2819|5556->2948|5585->2949|5614->2950|5655->2963|5684->2964|5713->2965|5753->2976|5783->2977|5813->2978|5852->2988|5882->2989|5912->2990|5956->3005|5986->3006|6016->3007|6056->3018|6086->3019|6116->3020|6300->3175|6330->3176|6360->3177|6402->3190|6432->3191|6462->3192|6493->3194|6523->3195|6553->3196|6596->3210|6626->3211|6656->3212|6753->3281|6782->3282|6811->3283|6849->3293|6878->3294|6907->3295|6944->3304|6973->3305|7002->3306|7044->3319|7074->3320|7104->3321|7135->3323|7165->3324|7195->3325|7238->3339|7268->3340|7298->3341|7594->3609|7623->3610|7679->3637|7709->3638|7774->3674|7804->3675|7834->3676|7889->3702|7919->3703|7949->3704|8009->3735|8039->3736|8069->3737|8127->3766|8157->3767|8187->3768|8217->3769|8247->3770|8277->3771|8334->3799|8364->3800|8394->3801|9414->4794|9429->4800|9501->4851|9581->4904|9596->4910|9662->4955|9742->5008|9757->5014|9833->5068|9913->5121|9928->5127|10004->5181|10084->5234|10099->5240|10176->5295|10256->5348|10271->5354|10329->5391|10409->5444|10424->5450|10477->5482|10557->5535|10572->5541|10631->5579|10711->5632|10726->5638|10782->5673|10862->5726|10877->5732|10943->5777|11023->5830|11038->5836|11106->5883|11186->5936|11201->5942|11267->5987|11347->6040|11362->6046|11439->6101|11523->6158|11538->6164|11618->6222|11701->6278|11716->6284|11786->6333|11866->6386|11881->6392|11942->6432|12022->6485|12037->6491|12107->6540|12187->6593|12202->6599|12286->6661|12366->6714|12381->6720|12459->6776
                  LINES: 26->1|29->1|30->2|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|51->23|51->23|51->23|52->24|52->24|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|111->83|111->83|111->83|112->84|112->84|112->84|113->85|113->85|113->85|114->86|114->86|114->86|115->87|115->87|115->87|116->88|116->88|116->88
                  -- GENERATED --
              */
          