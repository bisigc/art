
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
        <link href=""""),_display_(/*13.22*/routes/*13.28*/.Assets.at("stylesheets/jqcloud.min.css")),format.raw/*13.69*/("""" rel="stylesheet">
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
                            <li ng-repeat="menuItem in menuCtrl.menuItems" class="menuItem" ng-switch on="menuItem.type" ng-if="menuItem.pos === 'left'" ng-class=""""),format.raw/*30.164*/("""{"""),format.raw/*30.165*/(""" """),format.raw/*30.166*/("""active:menuCtrl.isMenuSet(menuItem.name), dropdown:menuItem.type === 'dropdown'"""),format.raw/*30.245*/("""}"""),format.raw/*30.246*/("""">
                                <a href ng-switch-when="dropdown" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">"""),format.raw/*31.150*/("""{"""),format.raw/*31.151*/("""{"""),format.raw/*31.152*/("""menuItem.fullname"""),format.raw/*31.169*/("""}"""),format.raw/*31.170*/("""}"""),format.raw/*31.171*/(""" """),format.raw/*31.172*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu" ng-switch-when="dropdown">
                                    <li ng-class=""""),format.raw/*33.51*/("""{"""),format.raw/*33.52*/(""" """),format.raw/*33.53*/("""active:menuCtrl.isMenuSet(submenuItem.name)"""),format.raw/*33.96*/("""}"""),format.raw/*33.97*/("""" ng-repeat="submenuItem in menuItem.subItems"><a href ng-click="menuCtrl.setMenu(submenuItem.name)">"""),format.raw/*33.198*/("""{"""),format.raw/*33.199*/("""{"""),format.raw/*33.200*/("""submenuItem.fullname"""),format.raw/*33.220*/("""}"""),format.raw/*33.221*/("""}"""),format.raw/*33.222*/("""</a></li>
                                </ul>
                                <a href ng-switch-when="home" class="homeitem" ng-click="menuCtrl.setMenu(menuItem.name)"><img ng-src=""""),format.raw/*35.136*/("""{"""),format.raw/*35.137*/("""{"""),format.raw/*35.138*/("""menuItem.image"""),format.raw/*35.152*/("""}"""),format.raw/*35.153*/("""}"""),format.raw/*35.154*/("""" /></a>
                                <a href ng-switch-default ng-click="menuCtrl.setMenu(menuItem.name)">"""),format.raw/*36.102*/("""{"""),format.raw/*36.103*/("""{"""),format.raw/*36.104*/("""menuItem.fullname"""),format.raw/*36.121*/("""}"""),format.raw/*36.122*/("""}"""),format.raw/*36.123*/("""</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li ng-show="userCtrl.user.loggedin"><a href>"""),format.raw/*40.74*/("""{"""),format.raw/*40.75*/("""{"""),format.raw/*40.76*/("""userCtrl.user.name"""),format.raw/*40.94*/("""}"""),format.raw/*40.95*/("""}"""),format.raw/*40.96*/("""</a></li>
                            <li ng-show="userCtrl.user.loggedin"><img ng-src=""""),format.raw/*41.79*/("""{"""),format.raw/*41.80*/("""{"""),format.raw/*41.81*/("""userCtrl.user.avatar"""),format.raw/*41.101*/("""}"""),format.raw/*41.102*/("""}"""),format.raw/*41.103*/("""" height="40px" /></li>
                            <!-- li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li -->
                            <li ng-show="userCtrl.user.loggedin" ng-class=""""),format.raw/*43.76*/("""{"""),format.raw/*43.77*/(""" """),format.raw/*43.78*/("""active:menuCtrl.isMenuSet('profile')"""),format.raw/*43.114*/("""}"""),format.raw/*43.115*/(""""><a href="#profile" ng-click="menuCtrl.setMenu('profile')">Profile</a></li>
                            <li ng-hide="userCtrl.user.loggedin"><a href ng-click="userCtrl.login()">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin"><a href ng-click="userCtrl.logout()">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </nav>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron" ng-show="menuCtrl.isMenuSet('home')">
                <h1>Architectural Refactoring</h1>
                <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
                <p>
                    <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
                </p>
            </div>

            <div id="arpane" ng-show="menuCtrl.isMenuSet('ars')" ng-controller="ARController as arCtrl">
                <div class="jumbotron">
                    <h1>Architectural Refactorings</h1>
                    <p>Descewrfwerfwerf</p>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <table id="searchObjResults" class="table table-striped table-hover">
                            <tr><th>Name</th><th>Description</th><th>Smells</th></tr>
                            <tr><td><input ng-model="search.name" placeholder="Enter search criteria" /></td><td><input ng-model="search.desc" placeholder="Enter search criteria" /></td><td><input ng-model="search.smells.name" id="smellname" placeholder="Enter search criteria" /></td></tr>
                            <tr><th><a href="" ng-click="reverseName=!reverseName;arCtrl.order('name', reverseName)">Name <span ng-show="reverseName">&#x25B2;</span><span ng-show="!reverseName">&#x25BC;</span></a></th><th><a href="" ng-click="reverseDesc=!reverseDesc;arCtrl.order('desc', reverseDesc)">Description <span ng-show="reverseDesc">&#x25B2;</span><span ng-show="!reverseDesc">&#x25BC;</span></a></th><th><a href="" ng-click="reverseSmells=!reverseSmells;arCtrl.order('smells.name', reverseSmells)">Smells <span ng-show="reverseSmells">&#x25B2;</span><span ng-show="!reverseSmells">&#x25BC;</span></a></th></tr>
                            <tr ng-repeat="ar in arCtrl.arlist | filter:search">
                                <td>"""),format.raw/*72.37*/("""{"""),format.raw/*72.38*/("""{"""),format.raw/*72.39*/("""ar.name"""),format.raw/*72.46*/("""}"""),format.raw/*72.47*/("""}"""),format.raw/*72.48*/("""</td>
                                <td>"""),format.raw/*73.37*/("""{"""),format.raw/*73.38*/("""{"""),format.raw/*73.39*/("""ar.desc"""),format.raw/*73.46*/("""}"""),format.raw/*73.47*/("""}"""),format.raw/*73.48*/("""</td>
                                <td><span ng-repeat="smell in ar.smells">"""),format.raw/*74.74*/("""{"""),format.raw/*74.75*/("""{"""),format.raw/*74.76*/("""smell.name"""),format.raw/*74.86*/("""}"""),format.raw/*74.87*/("""}"""),format.raw/*74.88*/(""", </span></td>
                            </tr>
                        </table>
                        <pagination total-items="bigTotalItems" ng-model="bigCurrentPage" max-size="maxSize" class="pagination-sm" boundary-links="true" rotate="false" num-pages="numPages"></pagination>
                    </div>
                    <div class="col-md-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">Smell Cloud</div>
                            <div class="panel-body">
                                <jqcloud words="arCtrl.words" width="320" height="320" steps="6"></jqcloud>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="jumbotron" ng-show="menuCtrl.isMenuSet('addar')" ng-controller="ARController as arCtrl">
                <h2>Add Architectural Refactoring</h2>
                <p>Add an Architectural Refactoring fill out the form:</p>
                <p>
                    <a class="btn btn-lg btn-primary" ng-class=" active:arCtrl.formvisible" href role="button" ng-click="arCtrl.showForm(!arCtrl.formvisible);arCtrl.setProgValue()">Add AR &raquo;</a>
                </p>
                <div name="arFormContainer" ng-show="arCtrl.formvisible">
                    <p>
                        Completeness:
                        <!-- progressbar class="progress-striped active" value="dynamic" type=""""),format.raw/*99.96*/("""{"""),format.raw/*99.97*/("""{"""),format.raw/*99.98*/("""arCtrl.type"""),format.raw/*99.109*/("""}"""),format.raw/*99.110*/("""}"""),format.raw/*99.111*/("""">"""),format.raw/*99.113*/("""{"""),format.raw/*99.114*/("""{"""),format.raw/*99.115*/("""arCtrl.type"""),format.raw/*99.126*/("""}"""),format.raw/*99.127*/("""}"""),format.raw/*99.128*/(""" """),format.raw/*99.129*/("""<i ng-show="arCtrl.showWarning">!!! Watch out !!!</i></progressbar -->
                        <progress><bar ng-repeat="bar in arCtrl.progStacked track by $index" value="bar.value" type=""""),format.raw/*100.118*/("""{"""),format.raw/*100.119*/("""{"""),format.raw/*100.120*/("""bar.type"""),format.raw/*100.128*/("""}"""),format.raw/*100.129*/("""}"""),format.raw/*100.130*/(""""><span ng-hide="bar.value < 5">"""),format.raw/*100.162*/("""{"""),format.raw/*100.163*/("""{"""),format.raw/*100.164*/("""bar.value"""),format.raw/*100.173*/("""}"""),format.raw/*100.174*/("""}"""),format.raw/*100.175*/("""%</span></bar></progress>
                    </p>
                    <form name="arForm" ng-submit="arForm.$valid && arCtrl.addAr()" novalidate>
                        <!-- Live Preview -->
                        <blockquote>
                            Name: """),format.raw/*105.35*/("""{"""),format.raw/*105.36*/("""{"""),format.raw/*105.37*/("""arCtrl.ar.name"""),format.raw/*105.51*/("""}"""),format.raw/*105.52*/("""}"""),format.raw/*105.53*/("""
                        """),format.raw/*106.25*/("""</blockquote>
                        <!--  Review Form -->
                        <h4>Submit an AR</h4>
                        <!-- fieldset class="form-group">
<select class="form-control" ng-options="stars for stars in [5,4,3,2,1]"  title="Stars">
<option value="">Rate the Product</option>
</select>
</fieldset -->
                        <p>
                            Form valid: """),format.raw/*115.41*/("""{"""),format.raw/*115.42*/("""{"""),format.raw/*115.43*/("""arForm.$valid"""),format.raw/*115.56*/("""}"""),format.raw/*115.57*/("""}"""),format.raw/*115.58*/("""
                        """),format.raw/*116.25*/("""</p>
                        <fieldset class="form-group">
                            <label for="name">Name</label>
                            <input class="form-control" placeholder="Write a short review of the product..." title="name" id="name" ng-model="arCtrl.ar.name" required></input>
                        </fieldset>
                    <fieldset class="form-group">
                        <label for="context">Context</label>
                        <textarea class="form-control" placeholder="Write a short review of the product..." title="context" id="context" ng-model="arCtrl.ar.context" required></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="quality_attr">Quality Attributes</label>
                        <textarea class="form-control" placeholder="Write a short review of the product..." title="quality_attr" id="quality_attr" ng-model="arCtrl.ar.quality_attr" required></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="smell">Smells</label>
                        <textarea class="form-control" placeholder="Write a short review of the product..." title="smell" id="smell" ng-model="arCtrl.ar.smell" required></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="arc_decisions">Architectural decisions to be reviewed</label>
                        <textarea class="form-control" placeholder="Write a short review of the product..." title="arc_decisions" id="arc_decisions" ng-model="arCtrl.ar.arc_decisions" required></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="refactoring">Refactorings</label>
                        <textarea class="form-control" placeholder="Write a short review of the product..." title="refactoring" id="refactoring" ng-model="arCtrl.ar.refactoring" required></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="affected_comp">Affected Components</label>
                        <textarea class="form-control" placeholder="Write a short review of the product..." title="affected_comp" id="affected_comp" ng-model="arCtrl.ar.affected_comp" required></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="exec_tasks">Execution Tasks</label>
                        <textarea class="form-control" placeholder="Write a short review of the product..." title="exec_tasks" id="exec_tasks" ng-model="arCtrl.ar.exec_tasks" required></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="referenced_ars">Referenced ARs</label>
                        <textarea class="form-control" placeholder="Write a short review of the product..." title="referenced_ars" id="referenced_ars" ng-model="arCtrl.ar.referenced_ars" required></textarea>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="links">Links</label>
                        <textarea class="form-control" placeholder="Write a short review of the product..." title="links" id="links" ng-model="arCtrl.ar.links" required></textarea>
                    </fieldset>
                    <!-- fieldset class="form-group">
<input type="email" class="form-control" placeholder="jimmyDean&#64;example.org" title="Email" />
</fieldset -->
                    <fieldset class="form-group">
                        <input type="submit" class="btn btn-primary pull-right" value="Submit AR" />
                    </fieldset>
                    </form>
            </div>
        </div>

        <div class="jumbotron" ng-show="menuCtrl.isMenuSet('about')">
            <h1>About</h1>
            <p>About about About</p>
            <p>
                <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
            </p>
        </div>


        <div class="jumbotron" ng-show="menuCtrl.isMenuSet('contact')">
            <h1>Contact</h1>
            <p>Contact contact Contact</p>
            <p>
                <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
            </p>
        </div>

        <div class="jumbotron" ng-show="menuCtrl.isMenuSet('profile')">
            <h1>Profile</h1>
            <p>Profile profile profile</p>
            <p>
                <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
            </p>
        </div>

        </div> <!-- /container -->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src=""""),_display_(/*195.42*/routes/*195.48*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*195.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*196.42*/routes/*196.48*/.Assets.at("javascripts/app.js")),format.raw/*196.80*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*197.42*/routes/*197.48*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*197.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*198.42*/routes/*198.48*/.Assets.at("javascripts/libs/jqcloud.min.js")),format.raw/*198.93*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*199.42*/routes/*199.48*/.Assets.at("javascripts/libs/angular-jqcloud.js")),format.raw/*199.97*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*200.42*/routes/*200.48*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*200.110*/(""""></script>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Mar 20 01:32:04 CET 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: 13859c70649d07d20305b5618b8df22ecc2017a6
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1556->590|1624->631|1639->637|1701->678|2550->1498|2580->1499|2610->1500|2718->1579|2748->1580|2929->1732|2959->1733|2989->1734|3035->1751|3065->1752|3095->1753|3125->1754|3332->1933|3361->1934|3390->1935|3461->1978|3490->1979|3620->2080|3650->2081|3680->2082|3729->2102|3759->2103|3789->2104|4001->2287|4031->2288|4061->2289|4104->2303|4134->2304|4164->2305|4303->2415|4333->2416|4363->2417|4409->2434|4439->2435|4469->2436|4747->2686|4776->2687|4805->2688|4851->2706|4880->2707|4909->2708|5025->2796|5054->2797|5083->2798|5132->2818|5162->2819|5192->2820|5442->3042|5471->3043|5500->3044|5565->3080|5595->3081|8626->6084|8655->6085|8684->6086|8719->6093|8748->6094|8777->6095|8847->6137|8876->6138|8905->6139|8940->6146|8969->6147|8998->6148|9105->6227|9134->6228|9163->6229|9201->6239|9230->6240|9259->6241|10785->7739|10814->7740|10843->7741|10883->7752|10913->7753|10943->7754|10974->7756|11004->7757|11034->7758|11074->7769|11104->7770|11134->7771|11164->7772|11382->7960|11413->7961|11444->7962|11482->7970|11513->7971|11544->7972|11606->8004|11637->8005|11668->8006|11707->8015|11738->8016|11769->8017|12062->8281|12092->8282|12122->8283|12165->8297|12195->8298|12225->8299|12279->8324|12697->8713|12727->8714|12757->8715|12799->8728|12829->8729|12859->8730|12913->8755|17949->13763|17965->13769|18032->13814|18113->13867|18129->13873|18183->13905|18264->13958|18280->13964|18349->14011|18430->14064|18446->14070|18513->14115|18594->14168|18610->14174|18681->14223|18762->14276|18778->14282|18863->14344
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|58->30|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|59->31|59->31|59->31|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|69->41|71->43|71->43|71->43|71->43|71->43|100->72|100->72|100->72|100->72|100->72|100->72|101->73|101->73|101->73|101->73|101->73|101->73|102->74|102->74|102->74|102->74|102->74|102->74|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|133->105|133->105|133->105|133->105|133->105|133->105|134->106|143->115|143->115|143->115|143->115|143->115|143->115|144->116|223->195|223->195|223->195|224->196|224->196|224->196|225->197|225->197|225->197|226->198|226->198|226->198|227->199|227->199|227->199|228->200|228->200|228->200
                  -- GENERATED --
              */
          