
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
        <link href=""""),_display_(/*14.22*/routes/*14.28*/.Assets.at("stylesheets/select2.css")),format.raw/*14.65*/("""" rel="stylesheet">
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.at("stylesheets/selectize.default.css")),format.raw/*15.75*/("""" rel="stylesheet" >
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.at("stylesheets/jqcloud.min.css")),format.raw/*16.69*/("""" rel="stylesheet">
        <link href=""""),_display_(/*17.22*/routes/*17.28*/.Assets.at("stylesheets/ngNotificationsBar.min.css")),format.raw/*17.80*/("""" rel="stylesheet">
        <link href=""""),_display_(/*18.22*/routes/*18.28*/.Assets.at("stylesheets/main.css")),format.raw/*18.62*/("""" rel="stylesheet">
        <link href=""""),_display_(/*19.22*/routes/*19.28*/.Assets.at("stylesheets/tree.css")),format.raw/*19.62*/("""" rel="stylesheet">
        <link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.at("stylesheets/font-awesome.min.css")),format.raw/*20.74*/("""" rel="stylesheet">
        <link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.at("stylesheets/textAngular.css")),format.raw/*21.69*/("""" rel="stylesheet">
        <link href=""""),_display_(/*22.22*/routes/*22.28*/.Assets.at("stylesheets/awesome-bootstrap-checkbox.css")),format.raw/*22.84*/("""" rel="stylesheet">
        <script type="text/javascript">
            var _contextPath = """"),_display_(/*24.34*/routes/*24.40*/.Assets.at("")),format.raw/*24.54*/("""";
            var activeProfile = """"),_display_(/*25.35*/activeProfile),format.raw/*25.48*/("""";
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
                            <li ng-repeat="menui in menuItems" class="menuItem" ng-switch on="menui.type" ng-if="menui.pos === 'left'" ng-class=""""),format.raw/*42.146*/("""{"""),format.raw/*42.147*/("""dropdown:menui.type === 'dropdown', active:$state.is(menui.name)"""),format.raw/*42.211*/("""}"""),format.raw/*42.212*/("""">
                                <a ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" title=""""),format.raw/*43.116*/("""{"""),format.raw/*43.117*/("""{"""),format.raw/*43.118*/("""menui.tooltip"""),format.raw/*43.131*/("""}"""),format.raw/*43.132*/("""}"""),format.raw/*43.133*/("""" role="button" aria-expanded="false">"""),format.raw/*43.171*/("""{"""),format.raw/*43.172*/("""{"""),format.raw/*43.173*/("""menui.fullname"""),format.raw/*43.187*/("""}"""),format.raw/*43.188*/("""}"""),format.raw/*43.189*/(""" """),format.raw/*43.190*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-repeat="submenui in menui.subItems"><a ui-sref=""""),format.raw/*45.92*/("""{"""),format.raw/*45.93*/("""{"""),format.raw/*45.94*/("""submenui.name"""),format.raw/*45.107*/("""}"""),format.raw/*45.108*/("""}"""),format.raw/*45.109*/("""" title=""""),format.raw/*45.118*/("""{"""),format.raw/*45.119*/("""{"""),format.raw/*45.120*/("""submenui.tooltip"""),format.raw/*45.136*/("""}"""),format.raw/*45.137*/("""}"""),format.raw/*45.138*/("""" >"""),format.raw/*45.141*/("""{"""),format.raw/*45.142*/("""{"""),format.raw/*45.143*/("""submenui.fullname"""),format.raw/*45.160*/("""}"""),format.raw/*45.161*/("""}"""),format.raw/*45.162*/("""</a></li>
                                </ul>
                                <a ng-switch-when="home" class="homeitem" title=""""),format.raw/*47.82*/("""{"""),format.raw/*47.83*/("""{"""),format.raw/*47.84*/("""menui.tooltip"""),format.raw/*47.97*/("""}"""),format.raw/*47.98*/("""}"""),format.raw/*47.99*/("""" ui-sref=""""),format.raw/*47.110*/("""{"""),format.raw/*47.111*/("""{"""),format.raw/*47.112*/("""menui.name"""),format.raw/*47.122*/("""}"""),format.raw/*47.123*/("""}"""),format.raw/*47.124*/(""""><img ng-src=""""),format.raw/*47.139*/("""{"""),format.raw/*47.140*/("""{"""),format.raw/*47.141*/("""menui.image"""),format.raw/*47.152*/("""}"""),format.raw/*47.153*/("""}"""),format.raw/*47.154*/("""" class="menuimage img-responsive center-block" /></a>
                                <!-- a href ng-switch-default ng-click="setMenu(menui.name)" title=""""),format.raw/*48.101*/("""{"""),format.raw/*48.102*/("""{"""),format.raw/*48.103*/("""menui.tooltip"""),format.raw/*48.116*/("""}"""),format.raw/*48.117*/("""}"""),format.raw/*48.118*/("""">"""),format.raw/*48.120*/("""{"""),format.raw/*48.121*/("""{"""),format.raw/*48.122*/("""menui.fullname"""),format.raw/*48.136*/("""}"""),format.raw/*48.137*/("""}"""),format.raw/*48.138*/("""</a-->
                                <a ng-switch-default ui-sref=""""),format.raw/*49.63*/("""{"""),format.raw/*49.64*/("""{"""),format.raw/*49.65*/("""menui.name"""),format.raw/*49.75*/("""}"""),format.raw/*49.76*/("""}"""),format.raw/*49.77*/("""" title=""""),format.raw/*49.86*/("""{"""),format.raw/*49.87*/("""{"""),format.raw/*49.88*/("""menui.tooltip"""),format.raw/*49.101*/("""}"""),format.raw/*49.102*/("""}"""),format.raw/*49.103*/("""">"""),format.raw/*49.105*/("""{"""),format.raw/*49.106*/("""{"""),format.raw/*49.107*/("""menui.fullname"""),format.raw/*49.121*/("""}"""),format.raw/*49.122*/("""}"""),format.raw/*49.123*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-if="isLoggedin.check()" class="menuItem menuuser dropdown" ng-class=""""),format.raw/*53.105*/("""{"""),format.raw/*53.106*/("""active:$state.is('profile')"""),format.raw/*53.133*/("""}"""),format.raw/*53.134*/("""">
                                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><img ng-src=""""),format.raw/*54.132*/("""{"""),format.raw/*54.133*/("""{"""),format.raw/*54.134*/("""_contextPath + 'avatar/' + currentUser.profile.id"""),format.raw/*54.183*/("""}"""),format.raw/*54.184*/("""}"""),format.raw/*54.185*/("""" class="avatar img-circle" /> """),format.raw/*54.216*/("""{"""),format.raw/*54.217*/("""{"""),format.raw/*54.218*/("""currentUser.profile.firstname"""),format.raw/*54.247*/("""}"""),format.raw/*54.248*/("""}"""),format.raw/*54.249*/(""" """),format.raw/*54.250*/("""{"""),format.raw/*54.251*/("""{"""),format.raw/*54.252*/("""currentUser.profile.lastname"""),format.raw/*54.280*/("""}"""),format.raw/*54.281*/("""}"""),format.raw/*54.282*/(""" """),format.raw/*54.283*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a ui-sref="profile">Profile</a></li>
                                    <li><a ui-sref="usersearches">Saved Searches</a></li>
                                    <li role="presentation" class="divider"></li>
                                    <li><a href ng-click="logout()"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                                </ul>
                            </li>
                            <li ng-if="!isLoggedin.check()" class="menuItem dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" title="Login" role="button" aria-expanded="false"><span class="glyphicon glyphicon-log-in"></span> Login <span class="caret"></span></a>
                                <ul class="dropdown-menu login-dropdown" role="menu">
                                    <li><div ng-include="_contextPath + 'login.html'"></div></li>
                                </ul>
                            </li>
                        </ul>
                    </div><!--/.nav-collapse -->
            </nav>
            
            <div ui-view></div>
            <!-- div ng-include="_contextPath + menuItem"></div -->

        </div> <!-- /container -->
        <notifications-bar class="notifications"></notifications-bar>

    <script type="text/javascript" src=""""),_display_(/*78.42*/routes/*78.48*/.Assets.at("javascripts/libs/jquery-1.11.2.min.js")),format.raw/*78.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*79.42*/routes/*79.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*79.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*80.42*/routes/*80.48*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*80.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*81.42*/routes/*81.48*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*81.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*82.42*/routes/*82.48*/.Assets.at("javascripts/libs/angular-ui-router.min.js")),format.raw/*82.103*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*83.42*/routes/*83.48*/.Assets.at("javascripts/mockdata.js")),format.raw/*83.85*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*84.42*/routes/*84.48*/.Assets.at("javascripts/app.js")),format.raw/*84.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*85.42*/routes/*85.48*/.Assets.at("javascripts/factories.js")),format.raw/*85.86*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*86.42*/routes/*86.48*/.Assets.at("javascripts/config.js")),format.raw/*86.83*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*87.42*/routes/*87.48*/.Assets.at("javascripts/filterdirectives.js")),format.raw/*87.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*88.42*/routes/*88.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*88.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*89.42*/routes/*89.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*89.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*90.42*/routes/*90.48*/.Assets.at("javascripts/libs/textAngular-rangy.min.js")),format.raw/*90.103*/(""""></script>
    <!-- script type="text/javascript" src=""""),_display_(/*91.46*/routes/*91.52*/.Assets.at("javascripts/libs/textAngular-sanitize.min.js")),format.raw/*91.110*/(""""></script -->
    <script type="text/javascript" src=""""),_display_(/*92.42*/routes/*92.48*/.Assets.at("javascripts/libs/textAngular.min.js")),format.raw/*92.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*93.42*/routes/*93.48*/.Assets.at("javascripts/libs/select.js")),format.raw/*93.88*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*94.42*/routes/*94.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*94.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*95.42*/routes/*95.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*95.110*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*96.42*/routes/*96.48*/.Assets.at("javascripts/libs/ngNotificationsBar.min.js")),format.raw/*96.104*/(""""></script>
    </body>
</html>"""))}
  }

  def render(activeProfile:String): play.twirl.api.HtmlFormat.Appendable = apply(activeProfile)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (activeProfile) => apply(activeProfile)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon May 18 21:54:02 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: 1a60b693f6f628b399b9366bc97de827e69b750d
                  MATRIX: 723->1|834->24|861->25|1232->369|1247->375|1300->407|1405->485|1420->491|1484->534|1552->575|1567->581|1624->617|1692->658|1707->664|1765->701|1833->742|1848->748|1916->795|1985->837|2000->843|2062->884|2130->925|2145->931|2218->983|2286->1024|2301->1030|2356->1064|2424->1105|2439->1111|2494->1145|2562->1186|2577->1192|2644->1238|2712->1279|2727->1285|2789->1326|2857->1367|2872->1373|2949->1429|3069->1522|3084->1528|3119->1542|3183->1579|3217->1592|4009->2355|4039->2356|4132->2420|4162->2421|4309->2539|4339->2540|4369->2541|4411->2554|4441->2555|4471->2556|4538->2594|4568->2595|4598->2596|4641->2610|4671->2611|4701->2612|4731->2613|4979->2833|5008->2834|5037->2835|5079->2848|5109->2849|5139->2850|5177->2859|5207->2860|5237->2861|5282->2877|5312->2878|5342->2879|5374->2882|5404->2883|5434->2884|5480->2901|5510->2902|5540->2903|5697->3032|5726->3033|5755->3034|5796->3047|5825->3048|5854->3049|5894->3060|5924->3061|5954->3062|5993->3072|6023->3073|6053->3074|6097->3089|6127->3090|6157->3091|6197->3102|6227->3103|6257->3104|6441->3259|6471->3260|6501->3261|6543->3274|6573->3275|6603->3276|6634->3278|6664->3279|6694->3280|6737->3294|6767->3295|6797->3296|6894->3365|6923->3366|6952->3367|6990->3377|7019->3378|7048->3379|7085->3388|7114->3389|7143->3390|7185->3403|7215->3404|7245->3405|7276->3407|7306->3408|7336->3409|7379->3423|7409->3424|7439->3425|7749->3706|7779->3707|7835->3734|7865->3735|8028->3869|8058->3870|8088->3871|8166->3920|8196->3921|8226->3922|8286->3953|8316->3954|8346->3955|8404->3984|8434->3985|8464->3986|8494->3987|8524->3988|8554->3989|8611->4017|8641->4018|8671->4019|8701->4020|10208->5500|10223->5506|10295->5557|10375->5610|10390->5616|10456->5661|10536->5714|10551->5720|10627->5774|10707->5827|10722->5833|10798->5887|10878->5940|10893->5946|10970->6001|11050->6054|11065->6060|11123->6097|11203->6150|11218->6156|11271->6188|11351->6241|11366->6247|11425->6285|11505->6338|11520->6344|11576->6379|11656->6432|11671->6438|11737->6483|11817->6536|11832->6542|11900->6589|11980->6642|11995->6648|12061->6693|12141->6746|12156->6752|12233->6807|12317->6864|12332->6870|12412->6928|12495->6984|12510->6990|12580->7039|12660->7092|12675->7098|12736->7138|12816->7191|12831->7197|12901->7246|12981->7299|12996->7305|13080->7367|13160->7420|13175->7426|13253->7482
                  LINES: 26->1|29->1|30->2|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|106->78|106->78|106->78|107->79|107->79|107->79|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|111->83|111->83|111->83|112->84|112->84|112->84|113->85|113->85|113->85|114->86|114->86|114->86|115->87|115->87|115->87|116->88|116->88|116->88|117->89|117->89|117->89|118->90|118->90|118->90|119->91|119->91|119->91|120->92|120->92|120->92|121->93|121->93|121->93|122->94|122->94|122->94|123->95|123->95|123->95|124->96|124->96|124->96
                  -- GENERATED --
              */
          