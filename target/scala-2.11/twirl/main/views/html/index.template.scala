
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
                            <li ng-repeat="menui in menuItems" class="menuItem" ng-switch on="menui.type" ng-if="menui.pos === 'left'" ng-class=""""),format.raw/*39.146*/("""{"""),format.raw/*39.147*/("""dropdown:menui.type === 'dropdown'"""),format.raw/*39.181*/("""}"""),format.raw/*39.182*/("""">
                                <a ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" title=""""),format.raw/*40.116*/("""{"""),format.raw/*40.117*/("""{"""),format.raw/*40.118*/("""menui.tooltip"""),format.raw/*40.131*/("""}"""),format.raw/*40.132*/("""}"""),format.raw/*40.133*/("""" role="button" aria-expanded="false">"""),format.raw/*40.171*/("""{"""),format.raw/*40.172*/("""{"""),format.raw/*40.173*/("""menui.fullname"""),format.raw/*40.187*/("""}"""),format.raw/*40.188*/("""}"""),format.raw/*40.189*/(""" """),format.raw/*40.190*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-repeat="submenui in menui.subItems"><a ui-sref=""""),format.raw/*42.92*/("""{"""),format.raw/*42.93*/("""{"""),format.raw/*42.94*/("""submenui.name"""),format.raw/*42.107*/("""}"""),format.raw/*42.108*/("""}"""),format.raw/*42.109*/("""" ui-sref-active="active" title=""""),format.raw/*42.142*/("""{"""),format.raw/*42.143*/("""{"""),format.raw/*42.144*/("""submenui.tooltip"""),format.raw/*42.160*/("""}"""),format.raw/*42.161*/("""}"""),format.raw/*42.162*/("""" >"""),format.raw/*42.165*/("""{"""),format.raw/*42.166*/("""{"""),format.raw/*42.167*/("""submenui.fullname"""),format.raw/*42.184*/("""}"""),format.raw/*42.185*/("""}"""),format.raw/*42.186*/("""</a></li>
                                </ul>
                                <a ng-switch-when="home" class="homeitem" title=""""),format.raw/*44.82*/("""{"""),format.raw/*44.83*/("""{"""),format.raw/*44.84*/("""menui.tooltip"""),format.raw/*44.97*/("""}"""),format.raw/*44.98*/("""}"""),format.raw/*44.99*/("""" ui-sref=""""),format.raw/*44.110*/("""{"""),format.raw/*44.111*/("""{"""),format.raw/*44.112*/("""menui.name"""),format.raw/*44.122*/("""}"""),format.raw/*44.123*/("""}"""),format.raw/*44.124*/("""" ui-sref-active="active"><img ng-src=""""),format.raw/*44.163*/("""{"""),format.raw/*44.164*/("""{"""),format.raw/*44.165*/("""menui.image"""),format.raw/*44.176*/("""}"""),format.raw/*44.177*/("""}"""),format.raw/*44.178*/("""" class="menuimage img-responsive center-block" /></a>
                                <!-- a href ng-switch-default ng-click="setMenu(menui.name)" title=""""),format.raw/*45.101*/("""{"""),format.raw/*45.102*/("""{"""),format.raw/*45.103*/("""menui.tooltip"""),format.raw/*45.116*/("""}"""),format.raw/*45.117*/("""}"""),format.raw/*45.118*/("""">"""),format.raw/*45.120*/("""{"""),format.raw/*45.121*/("""{"""),format.raw/*45.122*/("""menui.fullname"""),format.raw/*45.136*/("""}"""),format.raw/*45.137*/("""}"""),format.raw/*45.138*/("""</a-->
                                <a ng-switch-default ui-sref=""""),format.raw/*46.63*/("""{"""),format.raw/*46.64*/("""{"""),format.raw/*46.65*/("""menui.name"""),format.raw/*46.75*/("""}"""),format.raw/*46.76*/("""}"""),format.raw/*46.77*/("""" ui-sref-active="active" title=""""),format.raw/*46.110*/("""{"""),format.raw/*46.111*/("""{"""),format.raw/*46.112*/("""menui.tooltip"""),format.raw/*46.125*/("""}"""),format.raw/*46.126*/("""}"""),format.raw/*46.127*/("""">"""),format.raw/*46.129*/("""{"""),format.raw/*46.130*/("""{"""),format.raw/*46.131*/("""menui.fullname"""),format.raw/*46.145*/("""}"""),format.raw/*46.146*/("""}"""),format.raw/*46.147*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="userCtrl.user.loggedin" class="menuItem menuuser"><a ui-sref="profile"  ui-sref-active="active"><img ng-src=""""),format.raw/*50.151*/("""{"""),format.raw/*50.152*/("""{"""),format.raw/*50.153*/("""userCtrl.user.avatar"""),format.raw/*50.173*/("""}"""),format.raw/*50.174*/("""}"""),format.raw/*50.175*/("""" class="avatar img-circle" /> """),format.raw/*50.206*/("""{"""),format.raw/*50.207*/("""{"""),format.raw/*50.208*/("""userCtrl.user.firstname"""),format.raw/*50.231*/("""}"""),format.raw/*50.232*/("""}"""),format.raw/*50.233*/(""" """),format.raw/*50.234*/("""{"""),format.raw/*50.235*/("""{"""),format.raw/*50.236*/("""userCtrl.user.surname"""),format.raw/*50.257*/("""}"""),format.raw/*50.258*/("""}"""),format.raw/*50.259*/("""</a></li>
                            <li ng-hide="userCtrl.user.loggedin" class="menuItem"><a href ng-click="userCtrl.login()">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin" class="menuItem"><a href ng-click="userCtrl.logout()">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
            </nav>
            
            <div ui-view></div>
            <!-- div ng-include="_contextPath + menuItem"></div -->

        </div> <!-- /container -->
        <notifications-bar class="notifications"></notifications-bar>

    <script type="text/javascript" src=""""),_display_(/*63.42*/routes/*63.48*/.Assets.at("javascripts/libs/jquery-1.11.2.min.js")),format.raw/*63.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*64.42*/routes/*64.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*64.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*65.42*/routes/*65.48*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*65.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*66.42*/routes/*66.48*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*66.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*67.42*/routes/*67.48*/.Assets.at("javascripts/libs/angular-ui-router.min.js")),format.raw/*67.103*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*68.42*/routes/*68.48*/.Assets.at("javascripts/mockdata.js")),format.raw/*68.85*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*69.42*/routes/*69.48*/.Assets.at("javascripts/app.js")),format.raw/*69.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*70.42*/routes/*70.48*/.Assets.at("javascripts/factories.js")),format.raw/*70.86*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*71.42*/routes/*71.48*/.Assets.at("javascripts/config.js")),format.raw/*71.83*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*72.42*/routes/*72.48*/.Assets.at("javascripts/filterdirectives.js")),format.raw/*72.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*73.42*/routes/*73.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*73.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*74.42*/routes/*74.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*74.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*75.42*/routes/*75.48*/.Assets.at("javascripts/libs/textAngular-rangy.min.js")),format.raw/*75.103*/(""""></script>
    <!-- script type="text/javascript" src=""""),_display_(/*76.46*/routes/*76.52*/.Assets.at("javascripts/libs/textAngular-sanitize.min.js")),format.raw/*76.110*/(""""></script -->
    <script type="text/javascript" src=""""),_display_(/*77.42*/routes/*77.48*/.Assets.at("javascripts/libs/textAngular.min.js")),format.raw/*77.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*78.42*/routes/*78.48*/.Assets.at("javascripts/libs/select.js")),format.raw/*78.88*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*79.42*/routes/*79.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*79.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*80.42*/routes/*80.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*80.110*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*81.42*/routes/*81.48*/.Assets.at("javascripts/libs/ngNotificationsBar.min.js")),format.raw/*81.104*/(""""></script>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Apr 15 16:52:50 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: e3bfa0593b5d8c3f278a661b6aed9b53ae861801
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1558->592|1626->633|1641->639|1709->686|1778->728|1793->734|1855->775|1923->816|1938->822|2011->874|2079->915|2094->921|2149->955|2217->996|2232->1002|2287->1036|2355->1077|2370->1083|2437->1129|2505->1170|2520->1176|2582->1217|2650->1258|2665->1264|2742->1320|2862->1413|2877->1419|2912->1433|3704->2196|3734->2197|3797->2231|3827->2232|3974->2350|4004->2351|4034->2352|4076->2365|4106->2366|4136->2367|4203->2405|4233->2406|4263->2407|4306->2421|4336->2422|4366->2423|4396->2424|4644->2644|4673->2645|4702->2646|4744->2659|4774->2660|4804->2661|4866->2694|4896->2695|4926->2696|4971->2712|5001->2713|5031->2714|5063->2717|5093->2718|5123->2719|5169->2736|5199->2737|5229->2738|5386->2867|5415->2868|5444->2869|5485->2882|5514->2883|5543->2884|5583->2895|5613->2896|5643->2897|5682->2907|5712->2908|5742->2909|5810->2948|5840->2949|5870->2950|5910->2961|5940->2962|5970->2963|6154->3118|6184->3119|6214->3120|6256->3133|6286->3134|6316->3135|6347->3137|6377->3138|6407->3139|6450->3153|6480->3154|6510->3155|6607->3224|6636->3225|6665->3226|6703->3236|6732->3237|6761->3238|6823->3271|6853->3272|6883->3273|6925->3286|6955->3287|6985->3288|7016->3290|7046->3291|7076->3292|7119->3306|7149->3307|7179->3308|7535->3635|7565->3636|7595->3637|7644->3657|7674->3658|7704->3659|7764->3690|7794->3691|7824->3692|7876->3715|7906->3716|7936->3717|7966->3718|7996->3719|8026->3720|8076->3741|8106->3742|8136->3743|8800->4380|8815->4386|8887->4437|8967->4490|8982->4496|9048->4541|9128->4594|9143->4600|9219->4654|9299->4707|9314->4713|9390->4767|9470->4820|9485->4826|9562->4881|9642->4934|9657->4940|9715->4977|9795->5030|9810->5036|9863->5068|9943->5121|9958->5127|10017->5165|10097->5218|10112->5224|10168->5259|10248->5312|10263->5318|10329->5363|10409->5416|10424->5422|10492->5469|10572->5522|10587->5528|10653->5573|10733->5626|10748->5632|10825->5687|10909->5744|10924->5750|11004->5808|11087->5864|11102->5870|11172->5919|11252->5972|11267->5978|11328->6018|11408->6071|11423->6077|11493->6126|11573->6179|11588->6185|11672->6247|11752->6300|11767->6306|11845->6362
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|50->22|50->22|50->22|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|108->80|108->80|108->80|109->81|109->81|109->81
                  -- GENERATED --
              */
          