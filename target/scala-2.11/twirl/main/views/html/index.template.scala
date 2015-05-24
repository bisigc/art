
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
        <div id="wrapper" class="container">
            <div ui-view="menu"></div>
            <div id="content" ui-view="container"></div>
            <div id="footer" ui-view="footer"></div>
        </div>

        <notifications-bar class="notifications"></notifications-bar>

        <script type="text/javascript" src=""""),_display_(/*43.46*/routes/*43.52*/.Assets.at("javascripts/libs/jquery-1.11.2.min.js")),format.raw/*43.103*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*44.46*/routes/*44.52*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*44.97*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*45.46*/routes/*45.52*/.Assets.at("javascripts/libs/angular-resource.min.js")),format.raw/*45.106*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*46.46*/routes/*46.52*/.Assets.at("javascripts/libs/angular-sanitize.min.js")),format.raw/*46.106*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*47.46*/routes/*47.52*/.Assets.at("javascripts/libs/angular-ui-router.min.js")),format.raw/*47.107*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*48.46*/routes/*48.52*/.Assets.at("javascripts/mockdata.js")),format.raw/*48.89*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*49.46*/routes/*49.52*/.Assets.at("javascripts/app.js")),format.raw/*49.84*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*50.46*/routes/*50.52*/.Assets.at("javascripts/factories.js")),format.raw/*50.90*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*51.46*/routes/*51.52*/.Assets.at("javascripts/config.js")),format.raw/*51.87*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*52.46*/routes/*52.52*/.Assets.at("javascripts/filterdirectives.js")),format.raw/*52.97*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*53.46*/routes/*53.52*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*53.99*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*54.46*/routes/*54.52*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*54.97*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*55.46*/routes/*55.52*/.Assets.at("javascripts/libs/textAngular-rangy.min.js")),format.raw/*55.107*/(""""></script>
        <!-- script type="text/javascript" src=""""),_display_(/*56.50*/routes/*56.56*/.Assets.at("javascripts/libs/textAngular-sanitize.min.js")),format.raw/*56.114*/(""""></script -->
        <script type="text/javascript" src=""""),_display_(/*57.46*/routes/*57.52*/.Assets.at("javascripts/libs/textAngular.min.js")),format.raw/*57.101*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*58.46*/routes/*58.52*/.Assets.at("javascripts/libs/select.js")),format.raw/*58.92*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*59.46*/routes/*59.52*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*59.101*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*60.46*/routes/*60.52*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*60.114*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*61.46*/routes/*61.52*/.Assets.at("javascripts/libs/ngNotificationsBar.min.js")),format.raw/*61.108*/(""""></script>
    </body>
</html>"""))}
  }

  def render(activeProfile:String): play.twirl.api.HtmlFormat.Appendable = apply(activeProfile)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (activeProfile) => apply(activeProfile)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat May 23 10:51:44 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: e2e1e5c56aff87d9b7af6698d0edad9be54914ef
                  MATRIX: 723->1|834->24|861->25|1232->369|1247->375|1300->407|1405->485|1420->491|1484->534|1552->575|1567->581|1624->617|1692->658|1707->664|1765->701|1833->742|1848->748|1916->795|1985->837|2000->843|2062->884|2130->925|2145->931|2218->983|2286->1024|2301->1030|2356->1064|2424->1105|2439->1111|2494->1145|2562->1186|2577->1192|2644->1238|2712->1279|2727->1285|2789->1326|2857->1367|2872->1373|2949->1429|3069->1522|3084->1528|3119->1542|3183->1579|3217->1592|3905->2253|3920->2259|3993->2310|4077->2367|4092->2373|4158->2418|4242->2475|4257->2481|4333->2535|4417->2592|4432->2598|4508->2652|4592->2709|4607->2715|4684->2770|4768->2827|4783->2833|4841->2870|4925->2927|4940->2933|4993->2965|5077->3022|5092->3028|5151->3066|5235->3123|5250->3129|5306->3164|5390->3221|5405->3227|5471->3272|5555->3329|5570->3335|5638->3382|5722->3439|5737->3445|5803->3490|5887->3547|5902->3553|5979->3608|6067->3669|6082->3675|6162->3733|6249->3793|6264->3799|6335->3848|6419->3905|6434->3911|6495->3951|6579->4008|6594->4014|6665->4063|6749->4120|6764->4126|6848->4188|6932->4245|6947->4251|7025->4307
                  LINES: 26->1|29->1|30->2|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61
                  -- GENERATED --
              */
          