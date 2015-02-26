
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
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html ng-app="artApp">

<head>
<title>title</title>
<link rel="stylesheet" media="screen" href=""""),_display_(/*6.46*/routes/*6.52*/.Assets.at("stylesheets/main.css")),format.raw/*6.86*/("""">
<link rel="shortcut icon" type="image/png" href=""""),_display_(/*7.51*/routes/*7.57*/.Assets.at("images/favicon.png")),format.raw/*7.89*/("""">
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular-resource.js"></script>
<script
	src=""""),_display_(/*13.8*/routes/*13.14*/.Assets.at("javascripts/angular-drag-and-drop-lists.js")),format.raw/*13.70*/(""""></script>
</head>

<body>

	<div ng-controller="eeppiCtrl">
		<h2>EEPPI Task Templates</h2>
		<p>Task Templates Check (Msg: """),format.raw/*20.33*/("""{"""),format.raw/*20.34*/("""{"""),format.raw/*20.35*/(""" """),format.raw/*20.36*/("""msg1 """),format.raw/*20.41*/("""}"""),format.raw/*20.42*/("""}"""),format.raw/*20.43*/("""):</p>
		<ul dnd-list="tasks.items">
			<li ng-repeat="task in tasks.items">"""),format.raw/*22.40*/("""{"""),format.raw/*22.41*/("""{"""),format.raw/*22.42*/(""" """),format.raw/*22.43*/("""task.id + ', ' + task.name """),format.raw/*22.70*/("""}"""),format.raw/*22.71*/("""}"""),format.raw/*22.72*/("""</li>
		</ul>
	</div>
	
	<div ng-controller="adRepoElementCtrl">
		<h2>ADRepo Elements</h2>
		<p>Elements Check (Msg: """),format.raw/*28.27*/("""{"""),format.raw/*28.28*/("""{"""),format.raw/*28.29*/(""" """),format.raw/*28.30*/("""msg2 """),format.raw/*28.35*/("""}"""),format.raw/*28.36*/("""}"""),format.raw/*28.37*/("""):</p>
		<ul dnd-list="element">
			<li ng-model="element">"""),format.raw/*30.27*/("""{"""),format.raw/*30.28*/("""{"""),format.raw/*30.29*/(""" """),format.raw/*30.30*/("""element.id + ', ' + element.name """),format.raw/*30.63*/("""}"""),format.raw/*30.64*/("""}"""),format.raw/*30.65*/("""</li>
		</ul>
	</div>
	
	<div ng-controller="ownTaskCtrl">
		<h2>Own Task Templates</h2>
		<p>Task Templates (Msg: """),format.raw/*36.27*/("""{"""),format.raw/*36.28*/("""{"""),format.raw/*36.29*/(""" """),format.raw/*36.30*/("""msg3 """),format.raw/*36.35*/("""}"""),format.raw/*36.36*/("""}"""),format.raw/*36.37*/("""):</p>
		<ul dnd-list="owntasks">
			<li ng-repeat="mytask in owntasks" dnd-draggable="mytask"
				dnd-moved="owntasks.splice($index, 1)" dnd-effect-allowed="move"
				dnd-selected="models.selected = mytask"
				ng-class=""""),format.raw/*41.15*/("""{"""),format.raw/*41.16*/("""'selected': mytask.selected === mytask"""),format.raw/*41.54*/("""}"""),format.raw/*41.55*/("""">"""),format.raw/*41.57*/("""{"""),format.raw/*41.58*/("""{"""),format.raw/*41.59*/("""
				"""),format.raw/*42.5*/("""mytask.id + ', ' + mytask.from_service + ', ' + mytask.created """),format.raw/*42.68*/("""}"""),format.raw/*42.69*/("""}"""),format.raw/*42.70*/("""</li>
		</ul>
	</div>

	<script src=""""),_display_(/*46.16*/routes/*46.22*/.Assets.at("javascripts/artApp.js")),format.raw/*46.57*/(""""></script>
	<script src=""""),_display_(/*47.16*/routes/*47.22*/.Assets.at("javascripts/artCtrls.js")),format.raw/*47.59*/(""""></script>
</body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Dec 19 13:34:53 CET 2014
                  SOURCE: /Users/cbi/Documents/play-apps/art-app/app/views/list.scala.html
                  HASH: ef6a5ac58d19099d80b60711adec90e55a0dce59
                  MATRIX: 797->0|936->113|950->119|1004->153|1083->206|1097->212|1149->244|1386->455|1401->461|1478->517|1632->643|1661->644|1690->645|1719->646|1752->651|1781->652|1810->653|1914->729|1943->730|1972->731|2001->732|2056->759|2085->760|2114->761|2260->879|2289->880|2318->881|2347->882|2380->887|2409->888|2438->889|2525->948|2554->949|2583->950|2612->951|2673->984|2702->985|2731->986|2874->1101|2903->1102|2932->1103|2961->1104|2994->1109|3023->1110|3052->1111|3302->1333|3331->1334|3397->1372|3426->1373|3456->1375|3485->1376|3514->1377|3546->1382|3637->1445|3666->1446|3695->1447|3760->1485|3775->1491|3831->1526|3885->1553|3900->1559|3958->1596
                  LINES: 29->1|34->6|34->6|34->6|35->7|35->7|35->7|41->13|41->13|41->13|48->20|48->20|48->20|48->20|48->20|48->20|48->20|50->22|50->22|50->22|50->22|50->22|50->22|50->22|56->28|56->28|56->28|56->28|56->28|56->28|56->28|58->30|58->30|58->30|58->30|58->30|58->30|58->30|64->36|64->36|64->36|64->36|64->36|64->36|64->36|69->41|69->41|69->41|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|74->46|74->46|74->46|75->47|75->47|75->47
                  -- GENERATED --
              */
          