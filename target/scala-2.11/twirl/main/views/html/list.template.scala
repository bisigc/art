
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object list_Scope0 {
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

class list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


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
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object list extends list_Scope0.list
              /*
                  -- GENERATED --
                  DATE: Sun Aug 09 22:47:31 CEST 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/list.scala.html
                  HASH: a52096c42f72f03ff5850fb169121460a843a801
                  MATRIX: 825->0|964->113|978->119|1032->153|1111->206|1125->212|1177->244|1412->452|1427->458|1504->514|1657->639|1686->640|1715->641|1744->642|1777->647|1806->648|1835->649|1939->725|1968->726|1997->727|2026->728|2081->755|2110->756|2139->757|2285->875|2314->876|2343->877|2372->878|2405->883|2434->884|2463->885|2550->944|2579->945|2608->946|2637->947|2698->980|2727->981|2756->982|2899->1097|2928->1098|2957->1099|2986->1100|3019->1105|3048->1106|3077->1107|3327->1329|3356->1330|3422->1368|3451->1369|3481->1371|3510->1372|3539->1373|3571->1378|3662->1441|3691->1442|3720->1443|3785->1481|3800->1487|3856->1522|3910->1549|3925->1555|3983->1592
                  LINES: 32->1|37->6|37->6|37->6|38->7|38->7|38->7|41->10|41->10|41->10|47->16|47->16|47->16|47->16|47->16|47->16|47->16|49->18|49->18|49->18|49->18|49->18|49->18|49->18|55->24|55->24|55->24|55->24|55->24|55->24|55->24|57->26|57->26|57->26|57->26|57->26|57->26|57->26|63->32|63->32|63->32|63->32|63->32|63->32|63->32|68->37|68->37|68->37|68->37|68->37|68->37|68->37|69->38|69->38|69->38|69->38|73->42|73->42|73->42|74->43|74->43|74->43
                  -- GENERATED --
              */
          