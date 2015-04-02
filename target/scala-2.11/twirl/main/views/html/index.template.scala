
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
        <link href=""""),_display_(/*14.22*/routes/*14.28*/.Assets.at("stylesheets/selectize.default.css")),format.raw/*14.75*/("""" rel="stylesheet" >
        <link href=""""),_display_(/*15.22*/routes/*15.28*/.Assets.at("stylesheets/jqcloud.min.css")),format.raw/*15.69*/("""" rel="stylesheet">
        <link href=""""),_display_(/*16.22*/routes/*16.28*/.Assets.at("stylesheets/ngNotificationsBar.min.css")),format.raw/*16.80*/("""" rel="stylesheet">
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
                            <li ng-repeat="menuItem in menuCtrl.menuItems" class="menuItem" ng-switch on="menuItem.type" ng-if="menuItem.pos === 'left'" ng-class=""""),format.raw/*33.164*/("""{"""),format.raw/*33.165*/(""" """),format.raw/*33.166*/("""active:menuCtrl.isMenuSet(menuItem.name), dropdown:menuItem.type === 'dropdown'"""),format.raw/*33.245*/("""}"""),format.raw/*33.246*/("""">
                                <a href ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">"""),format.raw/*34.150*/("""{"""),format.raw/*34.151*/("""{"""),format.raw/*34.152*/("""menuItem.fullname"""),format.raw/*34.169*/("""}"""),format.raw/*34.170*/("""}"""),format.raw/*34.171*/(""" """),format.raw/*34.172*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-class=""""),format.raw/*36.51*/("""{"""),format.raw/*36.52*/(""" """),format.raw/*36.53*/("""active:menuCtrl.isMenuSet(submenuItem.name)"""),format.raw/*36.96*/("""}"""),format.raw/*36.97*/("""" ng-repeat="submenuItem in menuItem.subItems"><a href ng-click="menuCtrl.setMenu(submenuItem.name)">"""),format.raw/*36.198*/("""{"""),format.raw/*36.199*/("""{"""),format.raw/*36.200*/("""submenuItem.fullname"""),format.raw/*36.220*/("""}"""),format.raw/*36.221*/("""}"""),format.raw/*36.222*/("""</a></li>
                                </ul>
                                <a href ng-switch-when="home" class="homeitem" ng-click="menuCtrl.setMenu(menuItem.name)"><img ng-src=""""),format.raw/*38.136*/("""{"""),format.raw/*38.137*/("""{"""),format.raw/*38.138*/("""menuItem.image"""),format.raw/*38.152*/("""}"""),format.raw/*38.153*/("""}"""),format.raw/*38.154*/("""" class="menuimage" /></a>
                                <a href ng-switch-default ng-click="menuCtrl.setMenu(menuItem.name)">"""),format.raw/*39.102*/("""{"""),format.raw/*39.103*/("""{"""),format.raw/*39.104*/("""menuItem.fullname"""),format.raw/*39.121*/("""}"""),format.raw/*39.122*/("""}"""),format.raw/*39.123*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="userCtrl.user.loggedin"><a href>"""),format.raw/*43.74*/("""{"""),format.raw/*43.75*/("""{"""),format.raw/*43.76*/("""userCtrl.user.name"""),format.raw/*43.94*/("""}"""),format.raw/*43.95*/("""}"""),format.raw/*43.96*/("""</a></li>
                            <li ng-show="userCtrl.user.loggedin"><img ng-src=""""),format.raw/*44.79*/("""{"""),format.raw/*44.80*/("""{"""),format.raw/*44.81*/("""userCtrl.user.avatar"""),format.raw/*44.101*/("""}"""),format.raw/*44.102*/("""}"""),format.raw/*44.103*/("""" height="40px" /></li>
                            <!-- li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li -->
                            <li ng-show="userCtrl.user.loggedin" ng-class=""""),format.raw/*46.76*/("""{"""),format.raw/*46.77*/(""" """),format.raw/*46.78*/("""active:menuCtrl.isMenuSet('profile')"""),format.raw/*46.114*/("""}"""),format.raw/*46.115*/(""""><a href ng-click="menuCtrl.setMenu('profile')">Profile</a></li>
                            <li ng-hide="userCtrl.user.loggedin"><a href ng-click="userCtrl.login()">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin"><a href ng-click="userCtrl.logout()">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </nav>
            
            <div ng-include="menuCtrl.menuItem"></div>

        </div> <!-- /container -->
        <notifications-bar class="notifications"></notifications-bar>

    <script type="text/javascript" src=""""),_display_(/*59.42*/routes/*59.48*/.Assets.at("javascripts/libs/jquery-1.11.2.min.js")),format.raw/*59.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*60.42*/routes/*60.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*60.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*61.42*/routes/*61.48*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*61.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*62.42*/routes/*62.48*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*62.102*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*63.42*/routes/*63.48*/.Assets.at("javascripts/app.js")),format.raw/*63.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*64.42*/routes/*64.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*64.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*65.42*/routes/*65.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*65.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*66.42*/routes/*66.48*/.Assets.at("javascripts/libs/select.js")),format.raw/*66.88*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*67.42*/routes/*67.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*67.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*68.42*/routes/*68.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*68.110*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*69.42*/routes/*69.48*/.Assets.at("javascripts/libs/ngNotificationsBar.min.js")),format.raw/*69.104*/(""""></script>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Apr 02 08:47:10 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: 2de26e276bb2237f6dfe9e81ea7c4df36782eab4
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1556->590|1624->631|1639->637|1696->673|1764->714|1779->720|1847->767|1916->809|1931->815|1993->856|2061->897|2076->903|2149->955|2998->1775|3028->1776|3058->1777|3166->1856|3196->1857|3377->2009|3407->2010|3437->2011|3483->2028|3513->2029|3543->2030|3573->2031|3780->2210|3809->2211|3838->2212|3909->2255|3938->2256|4068->2357|4098->2358|4128->2359|4177->2379|4207->2380|4237->2381|4449->2564|4479->2565|4509->2566|4552->2580|4582->2581|4612->2582|4769->2710|4799->2711|4829->2712|4875->2729|4905->2730|4935->2731|5213->2981|5242->2982|5271->2983|5317->3001|5346->3002|5375->3003|5491->3091|5520->3092|5549->3093|5598->3113|5628->3114|5658->3115|5908->3337|5937->3338|5966->3339|6031->3375|6061->3376|6725->4013|6740->4019|6812->4070|6892->4123|6907->4129|6973->4174|7053->4227|7068->4233|7144->4287|7224->4340|7239->4346|7315->4400|7395->4453|7410->4459|7463->4491|7543->4544|7558->4550|7626->4597|7706->4650|7721->4656|7787->4701|7867->4754|7882->4760|7943->4800|8023->4853|8038->4859|8108->4908|8188->4961|8203->4967|8287->5029|8367->5082|8382->5088|8460->5144
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|66->38|66->38|66->38|66->38|66->38|66->38|67->39|67->39|67->39|67->39|67->39|67->39|71->43|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|72->44|74->46|74->46|74->46|74->46|74->46|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69
                  -- GENERATED --
              */
          