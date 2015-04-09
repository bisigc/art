
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
        <script type="text/javascript">
            var _contextPath = """"),_display_(/*20.34*/routes/*20.40*/.Assets.at("")),format.raw/*20.54*/("""";
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
                            <li ng-repeat="menui in menuItems" class="menuItem" ng-switch on="menui.type" ng-if="menui.pos === 'left'" ng-class=""""),format.raw/*37.146*/("""{"""),format.raw/*37.147*/(""" """),format.raw/*37.148*/("""active:isMenuSet(menui.name), dropdown:menui.type === 'dropdown'"""),format.raw/*37.212*/("""}"""),format.raw/*37.213*/("""">
                                <a href ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" title=""""),format.raw/*38.121*/("""{"""),format.raw/*38.122*/("""{"""),format.raw/*38.123*/("""menui.tooltip"""),format.raw/*38.136*/("""}"""),format.raw/*38.137*/("""}"""),format.raw/*38.138*/("""" role="button" aria-expanded="false">"""),format.raw/*38.176*/("""{"""),format.raw/*38.177*/("""{"""),format.raw/*38.178*/("""menui.fullname"""),format.raw/*38.192*/("""}"""),format.raw/*38.193*/("""}"""),format.raw/*38.194*/(""" """),format.raw/*38.195*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-class=""""),format.raw/*40.51*/("""{"""),format.raw/*40.52*/(""" """),format.raw/*40.53*/("""active:isMenuSet(submenui.name)"""),format.raw/*40.84*/("""}"""),format.raw/*40.85*/("""" ng-repeat="submenui in menui.subItems"><a href ng-click="setMenu(submenui.name)" title=""""),format.raw/*40.175*/("""{"""),format.raw/*40.176*/("""{"""),format.raw/*40.177*/("""submenui.tooltip"""),format.raw/*40.193*/("""}"""),format.raw/*40.194*/("""}"""),format.raw/*40.195*/("""" >"""),format.raw/*40.198*/("""{"""),format.raw/*40.199*/("""{"""),format.raw/*40.200*/("""submenui.fullname"""),format.raw/*40.217*/("""}"""),format.raw/*40.218*/("""}"""),format.raw/*40.219*/("""</a></li>
                                </ul>
                                <a href ng-switch-when="home" class="homeitem" title=""""),format.raw/*42.87*/("""{"""),format.raw/*42.88*/("""{"""),format.raw/*42.89*/("""menui.tooltip"""),format.raw/*42.102*/("""}"""),format.raw/*42.103*/("""}"""),format.raw/*42.104*/("""" ng-click="setMenu(menui.name)"><img ng-src=""""),format.raw/*42.150*/("""{"""),format.raw/*42.151*/("""{"""),format.raw/*42.152*/("""menui.image"""),format.raw/*42.163*/("""}"""),format.raw/*42.164*/("""}"""),format.raw/*42.165*/("""" class="menuimage" /></a>
                                <a href ng-switch-default ng-click="setMenu(menui.name)" title=""""),format.raw/*43.97*/("""{"""),format.raw/*43.98*/("""{"""),format.raw/*43.99*/("""menui.tooltip"""),format.raw/*43.112*/("""}"""),format.raw/*43.113*/("""}"""),format.raw/*43.114*/("""">"""),format.raw/*43.116*/("""{"""),format.raw/*43.117*/("""{"""),format.raw/*43.118*/("""menui.fullname"""),format.raw/*43.132*/("""}"""),format.raw/*43.133*/("""}"""),format.raw/*43.134*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="userCtrl.user.loggedin"><a href>"""),format.raw/*47.74*/("""{"""),format.raw/*47.75*/("""{"""),format.raw/*47.76*/("""userCtrl.user.name"""),format.raw/*47.94*/("""}"""),format.raw/*47.95*/("""}"""),format.raw/*47.96*/("""</a></li>
                            <li ng-show="userCtrl.user.loggedin"><img ng-src=""""),format.raw/*48.79*/("""{"""),format.raw/*48.80*/("""{"""),format.raw/*48.81*/("""userCtrl.user.avatar"""),format.raw/*48.101*/("""}"""),format.raw/*48.102*/("""}"""),format.raw/*48.103*/("""" height="40px" /></li>
                            <!-- li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li -->
                            <li ng-show="userCtrl.user.loggedin" ng-class=""""),format.raw/*50.76*/("""{"""),format.raw/*50.77*/(""" """),format.raw/*50.78*/("""active:isMenuSet('profile')"""),format.raw/*50.105*/("""}"""),format.raw/*50.106*/(""""><a href ng-click="setMenu('profile')">Profile</a></li>
                            <li ng-hide="userCtrl.user.loggedin"><a href ng-click="userCtrl.login()">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin"><a href ng-click="userCtrl.logout()">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
            </nav>
            
            <div ng-include="_contextPath + menuItem"></div>

        </div> <!-- /container -->
        <notifications-bar class="notifications"></notifications-bar>

    <script type="text/javascript" src=""""),_display_(/*62.42*/routes/*62.48*/.Assets.at("javascripts/libs/jquery-1.11.2.min.js")),format.raw/*62.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*63.42*/routes/*63.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*63.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*64.42*/routes/*64.48*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*64.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*65.42*/routes/*65.48*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*65.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*66.42*/routes/*66.48*/.Assets.at("javascripts/app.js")),format.raw/*66.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*67.42*/routes/*67.48*/.Assets.at("javascripts/factories.js")),format.raw/*67.86*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*68.42*/routes/*68.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*68.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*69.42*/routes/*69.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*69.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*70.42*/routes/*70.48*/.Assets.at("javascripts/libs/textAngular-rangy.min.js")),format.raw/*70.103*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*71.42*/routes/*71.48*/.Assets.at("javascripts/libs/textAngular-sanitize.min.js")),format.raw/*71.106*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*72.42*/routes/*72.48*/.Assets.at("javascripts/libs/textAngular.min.js")),format.raw/*72.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*73.42*/routes/*73.48*/.Assets.at("javascripts/libs/select.js")),format.raw/*73.88*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*74.42*/routes/*74.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*74.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*75.42*/routes/*75.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*75.110*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*76.42*/routes/*76.48*/.Assets.at("javascripts/libs/ngNotificationsBar.min.js")),format.raw/*76.104*/(""""></script>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Apr 08 16:02:26 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: 21f0734c2b1b3b80a048120da9cc745bc2942d20
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1558->592|1626->633|1641->639|1709->686|1778->728|1793->734|1855->775|1923->816|1938->822|2011->874|2079->915|2094->921|2149->955|2217->996|2232->1002|2287->1036|2355->1077|2370->1083|2437->1129|2557->1222|2572->1228|2607->1242|3399->2005|3429->2006|3459->2007|3552->2071|3582->2072|3734->2195|3764->2196|3794->2197|3836->2210|3866->2211|3896->2212|3963->2250|3993->2251|4023->2252|4066->2266|4096->2267|4126->2268|4156->2269|4363->2448|4392->2449|4421->2450|4480->2481|4509->2482|4628->2572|4658->2573|4688->2574|4733->2590|4763->2591|4793->2592|4825->2595|4855->2596|4885->2597|4931->2614|4961->2615|4991->2616|5153->2750|5182->2751|5211->2752|5253->2765|5283->2766|5313->2767|5388->2813|5418->2814|5448->2815|5488->2826|5518->2827|5548->2828|5699->2951|5728->2952|5757->2953|5799->2966|5829->2967|5859->2968|5890->2970|5920->2971|5950->2972|5993->2986|6023->2987|6053->2988|6331->3238|6360->3239|6389->3240|6435->3258|6464->3259|6493->3260|6609->3348|6638->3349|6667->3350|6716->3370|6746->3371|6776->3372|7026->3594|7055->3595|7084->3596|7140->3623|7170->3624|7808->4235|7823->4241|7895->4292|7975->4345|7990->4351|8056->4396|8136->4449|8151->4455|8227->4509|8307->4562|8322->4568|8398->4622|8478->4675|8493->4681|8546->4713|8626->4766|8641->4772|8700->4810|8780->4863|8795->4869|8863->4916|8943->4969|8958->4975|9024->5020|9104->5073|9119->5079|9196->5134|9276->5187|9291->5193|9371->5251|9451->5304|9466->5310|9536->5359|9616->5412|9631->5418|9692->5458|9772->5511|9787->5517|9857->5566|9937->5619|9952->5625|10036->5687|10116->5740|10131->5746|10209->5802
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|48->20|48->20|48->20|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|75->47|75->47|75->47|75->47|75->47|75->47|76->48|76->48|76->48|76->48|76->48|76->48|78->50|78->50|78->50|78->50|78->50|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|104->76|104->76|104->76
                  -- GENERATED --
              */
          