
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(activeProfile: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


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
</html>"""))
      }
    }
  }

  def render(activeProfile:String): play.twirl.api.HtmlFormat.Appendable = apply(activeProfile)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (activeProfile) => apply(activeProfile)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Sun Aug 09 22:47:31 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: 688d210ced8f0e54933c0d70686c1e82a5e5af42
                  MATRIX: 745->1|863->24|890->25|1261->369|1276->375|1329->407|1434->485|1449->491|1513->534|1581->575|1596->581|1653->617|1721->658|1736->664|1794->701|1862->742|1877->748|1945->795|2014->837|2029->843|2091->884|2159->925|2174->931|2247->983|2315->1024|2330->1030|2385->1064|2453->1105|2468->1111|2523->1145|2591->1186|2606->1192|2673->1238|2741->1279|2756->1285|2818->1326|2886->1367|2901->1373|2978->1429|3098->1522|3113->1528|3148->1542|3212->1579|3246->1592|3934->2253|3949->2259|4022->2310|4106->2367|4121->2373|4187->2418|4271->2475|4286->2481|4362->2535|4446->2592|4461->2598|4537->2652|4621->2709|4636->2715|4713->2770|4797->2827|4812->2833|4870->2870|4954->2927|4969->2933|5022->2965|5106->3022|5121->3028|5180->3066|5264->3123|5279->3129|5335->3164|5419->3221|5434->3227|5500->3272|5584->3329|5599->3335|5667->3382|5751->3439|5766->3445|5832->3490|5916->3547|5931->3553|6008->3608|6096->3669|6111->3675|6191->3733|6278->3793|6293->3799|6364->3848|6448->3905|6463->3911|6524->3951|6608->4008|6623->4014|6694->4063|6778->4120|6793->4126|6877->4188|6961->4245|6976->4251|7054->4307
                  LINES: 27->1|32->1|33->2|41->10|41->10|41->10|43->12|43->12|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|49->18|49->18|49->18|50->19|50->19|50->19|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|55->24|55->24|55->24|56->25|56->25|74->43|74->43|74->43|75->44|75->44|75->44|76->45|76->45|76->45|77->46|77->46|77->46|78->47|78->47|78->47|79->48|79->48|79->48|80->49|80->49|80->49|81->50|81->50|81->50|82->51|82->51|82->51|83->52|83->52|83->52|84->53|84->53|84->53|85->54|85->54|85->54|86->55|86->55|86->55|87->56|87->56|87->56|88->57|88->57|88->57|89->58|89->58|89->58|90->59|90->59|90->59|91->60|91->60|91->60|92->61|92->61|92->61
                  -- GENERATED --
              */
          