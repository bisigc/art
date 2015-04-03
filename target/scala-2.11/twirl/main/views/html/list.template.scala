
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
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular-resource.js"></script>
<script src=""""),_display_(/*10.15*/routes/*10.21*/.Assets.at("javascripts/angular-drag-and-drop-lists.js")),format.raw/*10.77*/(""""></script>
</head>

<body>
	<div ng-controller="eeppiCtrl">
		<h2>EEPPI Task Templates</h2>
		<p>Task Templates Check (Msg: """),format.raw/*16.33*/("""{"""),format.raw/*16.34*/("""{"""),format.raw/*16.35*/(""" """),format.raw/*16.36*/("""msg1 """),format.raw/*16.41*/("""}"""),format.raw/*16.42*/("""}"""),format.raw/*16.43*/("""):</p>
		<ul dnd-list="tasks.items">
			<li ng-repeat="task in tasks.items">"""),format.raw/*18.40*/("""{"""),format.raw/*18.41*/("""{"""),format.raw/*18.42*/(""" """),format.raw/*18.43*/("""task.id + ', ' + task.name """),format.raw/*18.70*/("""}"""),format.raw/*18.71*/("""}"""),format.raw/*18.72*/("""</li>
		</ul>
	</div>
	
	<div ng-controller="adRepoElementCtrl">
		<h2>ADRepo Elements</h2>
		<p>Elements Check (Msg: """),format.raw/*24.27*/("""{"""),format.raw/*24.28*/("""{"""),format.raw/*24.29*/(""" """),format.raw/*24.30*/("""msg2 """),format.raw/*24.35*/("""}"""),format.raw/*24.36*/("""}"""),format.raw/*24.37*/("""):</p>
		<ul dnd-list="element">
			<li ng-model="element">"""),format.raw/*26.27*/("""{"""),format.raw/*26.28*/("""{"""),format.raw/*26.29*/(""" """),format.raw/*26.30*/("""element.id + ', ' + element.name """),format.raw/*26.63*/("""}"""),format.raw/*26.64*/("""}"""),format.raw/*26.65*/("""</li>
		</ul>
	</div>
	
	<div ng-controller="ownTaskCtrl">
		<h2>Own Task Templates</h2>
		<p>Task Templates (Msg: """),format.raw/*32.27*/("""{"""),format.raw/*32.28*/("""{"""),format.raw/*32.29*/(""" """),format.raw/*32.30*/("""msg3 """),format.raw/*32.35*/("""}"""),format.raw/*32.36*/("""}"""),format.raw/*32.37*/("""):</p>
		<ul dnd-list="owntasks">
			<li ng-repeat="mytask in owntasks" dnd-draggable="mytask"
				dnd-moved="owntasks.splice($index, 1)" dnd-effect-allowed="move"
				dnd-selected="models.selected = mytask"
				ng-class=""""),format.raw/*37.15*/("""{"""),format.raw/*37.16*/("""'selected': mytask.selected === mytask"""),format.raw/*37.54*/("""}"""),format.raw/*37.55*/("""">"""),format.raw/*37.57*/("""{"""),format.raw/*37.58*/("""{"""),format.raw/*37.59*/("""
				"""),format.raw/*38.5*/("""mytask.id + ', ' + mytask.from_service + ', ' + mytask.created """),format.raw/*38.68*/("""}"""),format.raw/*38.69*/("""}"""),format.raw/*38.70*/("""</li>
		</ul>
	</div>

	<script src=""""),_display_(/*42.16*/routes/*42.22*/.Assets.at("javascripts/artApp.js")),format.raw/*42.57*/(""""></script>
	<script src=""""),_display_(/*43.16*/routes/*43.22*/.Assets.at("javascripts/artCtrls.js")),format.raw/*43.59*/(""""></script>
</body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Apr 03 14:37:26 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/list.scala.html
                  HASH: b43d6a2d3fc8a606ae218035839371538f02b146
                  MATRIX: 797->0|936->113|950->119|1004->153|1083->206|1097->212|1149->244|1384->452|1399->458|1476->514|1629->639|1658->640|1687->641|1716->642|1749->647|1778->648|1807->649|1911->725|1940->726|1969->727|1998->728|2053->755|2082->756|2111->757|2257->875|2286->876|2315->877|2344->878|2377->883|2406->884|2435->885|2522->944|2551->945|2580->946|2609->947|2670->980|2699->981|2728->982|2871->1097|2900->1098|2929->1099|2958->1100|2991->1105|3020->1106|3049->1107|3299->1329|3328->1330|3394->1368|3423->1369|3453->1371|3482->1372|3511->1373|3543->1378|3634->1441|3663->1442|3692->1443|3757->1481|3772->1487|3828->1522|3882->1549|3897->1555|3955->1592
                  LINES: 29->1|34->6|34->6|34->6|35->7|35->7|35->7|38->10|38->10|38->10|44->16|44->16|44->16|44->16|44->16|44->16|44->16|46->18|46->18|46->18|46->18|46->18|46->18|46->18|52->24|52->24|52->24|52->24|52->24|52->24|52->24|54->26|54->26|54->26|54->26|54->26|54->26|54->26|60->32|60->32|60->32|60->32|60->32|60->32|60->32|65->37|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|66->38|70->42|70->42|70->42|71->43|71->43|71->43
                  -- GENERATED --
              */
          