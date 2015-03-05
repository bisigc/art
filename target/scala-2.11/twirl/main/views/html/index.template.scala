
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
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#"><img src="images/art_logo_small.png" height="100%"/></a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li ng-class=""""),format.raw/*38.43*/("""{"""),format.raw/*38.44*/(""" """),format.raw/*38.45*/("""active:menuCtrl.isMenuSet('home')"""),format.raw/*38.78*/("""}"""),format.raw/*38.79*/(""""><a href ng-click="menuCtrl.setMenu('home')">Home</a></li>
                            <li ng-class=""""),format.raw/*39.43*/("""{"""),format.raw/*39.44*/(""" """),format.raw/*39.45*/("""active:menuCtrl.isMenuSet('ars')"""),format.raw/*39.77*/("""}"""),format.raw/*39.78*/(""""><a href ng-click="menuCtrl.setMenu('ars')">ARs</a></li>
                            <li ng-class=""""),format.raw/*40.43*/("""{"""),format.raw/*40.44*/(""" """),format.raw/*40.45*/("""active:menuCtrl.isMenuSet('about')"""),format.raw/*40.79*/("""}"""),format.raw/*40.80*/(""""><a href ng-click="menuCtrl.setMenu('about')">About</a></li>
                            <li ng-class=""""),format.raw/*41.43*/("""{"""),format.raw/*41.44*/(""" """),format.raw/*41.45*/("""active:menuCtrl.isMenuSet('contact')"""),format.raw/*41.81*/("""}"""),format.raw/*41.82*/(""""><a href ng-click="menuCtrl.setMenu('contact')">Contact</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li class="dropdown-header">Nav header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right" ng-controller="UserController as userCtrl">
                            <li>"""),format.raw/*56.33*/("""{"""),format.raw/*56.34*/("""{"""),format.raw/*56.35*/("""userCtrl.user.name"""),format.raw/*56.53*/("""}"""),format.raw/*56.54*/("""}"""),format.raw/*56.55*/("""</li>
                            <li><img ng-src=""""),format.raw/*57.46*/("""{"""),format.raw/*57.47*/("""{"""),format.raw/*57.48*/("""userCtrl.user.avatar"""),format.raw/*57.68*/("""}"""),format.raw/*57.69*/("""}"""),format.raw/*57.70*/("""" height="40px" /></li>
                            <!-- li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li -->
                            <li ng-class=""""),format.raw/*59.43*/("""{"""),format.raw/*59.44*/(""" """),format.raw/*59.45*/("""active:menuCtrl.isMenuSet('profile')"""),format.raw/*59.81*/("""}"""),format.raw/*59.82*/(""""><a href="#profile" ng-click="menuCtrl.setMenu('profile')">Profile</a></li>
                            <li ng-hide="userCtrl.user.loggedin"><a href="#login">Login</a></li>
                            <li ng-show="userCtrl.user.loggedin"><a href="#logout">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron" ng-show="menuCtrl.isMenuSet('home')">
                <h1>Architectural Refactoring</h1>
                <p>Home home Home</p>
                <p>
                    <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
                </p>
            </div>

            <div class="jumbotron" ng-show="menuCtrl.isMenuSet('ars')" ng-controller="ARController as arCtrl">
                <h2>Architectural Refactorings</h2>
                <p>Add an Architectural Refactoring fill out the form:</p>
                <p>
                    <a class="btn btn-lg btn-primary" ng-class=" active:arCtrl.formvisible" href role="button" ng-click="arCtrl.showForm(!arCtrl.formvisible);arCtrl.setProgValue()">Add AR &raquo;</a>
                </p>
                <div name="arFormContainer" ng-show="arCtrl.formvisible">
                    <p>
                        Completeness:
                        <!-- progressbar class="progress-striped active" value="dynamic" type=""""),format.raw/*85.96*/("""{"""),format.raw/*85.97*/("""{"""),format.raw/*85.98*/("""arCtrl.type"""),format.raw/*85.109*/("""}"""),format.raw/*85.110*/("""}"""),format.raw/*85.111*/("""">"""),format.raw/*85.113*/("""{"""),format.raw/*85.114*/("""{"""),format.raw/*85.115*/("""arCtrl.type"""),format.raw/*85.126*/("""}"""),format.raw/*85.127*/("""}"""),format.raw/*85.128*/(""" """),format.raw/*85.129*/("""<i ng-show="arCtrl.showWarning">!!! Watch out !!!</i></progressbar -->
                        <progress><bar ng-repeat="bar in arCtrl.progStacked track by $index" value="bar.value" type=""""),format.raw/*86.118*/("""{"""),format.raw/*86.119*/("""{"""),format.raw/*86.120*/("""bar.type"""),format.raw/*86.128*/("""}"""),format.raw/*86.129*/("""}"""),format.raw/*86.130*/(""""><span ng-hide="bar.value < 5">"""),format.raw/*86.162*/("""{"""),format.raw/*86.163*/("""{"""),format.raw/*86.164*/("""bar.value"""),format.raw/*86.173*/("""}"""),format.raw/*86.174*/("""}"""),format.raw/*86.175*/("""%</span></bar></progress>
                    </p>
                    <form name="arForm" ng-submit="arForm.$valid && arCtrl.addAr()" novalidate>
                        <!-- Live Preview -->
                        <blockquote>
                            Name: """),format.raw/*91.35*/("""{"""),format.raw/*91.36*/("""{"""),format.raw/*91.37*/("""arCtrl.ar.name"""),format.raw/*91.51*/("""}"""),format.raw/*91.52*/("""}"""),format.raw/*91.53*/("""
                        """),format.raw/*92.25*/("""</blockquote>
                        <!--  Review Form -->
                        <h4>Submit an AR</h4>
                        <!-- fieldset class="form-group">
<select class="form-control" ng-options="stars for stars in [5,4,3,2,1]"  title="Stars">
<option value="">Rate the Product</option>
</select>
</fieldset -->
                        <p>
                            Form valid: """),format.raw/*101.41*/("""{"""),format.raw/*101.42*/("""{"""),format.raw/*101.43*/("""arForm.$valid"""),format.raw/*101.56*/("""}"""),format.raw/*101.57*/("""}"""),format.raw/*101.58*/("""
                        """),format.raw/*102.25*/("""</p>
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
                    <ul ng-repeat="ar in arCtrl.arlist">
                        <li>
                            <blockquote>
                                """),format.raw/*153.33*/("""{"""),format.raw/*153.34*/("""{"""),format.raw/*153.35*/("""ar.name"""),format.raw/*153.42*/("""}"""),format.raw/*153.43*/("""}"""),format.raw/*153.44*/("""
                                """),format.raw/*154.33*/("""{"""),format.raw/*154.34*/("""{"""),format.raw/*154.35*/("""ar.createdOn | date"""),format.raw/*154.54*/("""}"""),format.raw/*154.55*/("""}"""),format.raw/*154.56*/("""
                            """),format.raw/*155.29*/("""</blockquote>
                        </li>
                    </ul>
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
        <script type="text/javascript" src=""""),_display_(/*189.46*/routes/*189.52*/.Assets.at("javascripts/libs/angular.min.js")),format.raw/*189.97*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*190.46*/routes/*190.52*/.Assets.at("javascripts/app.js")),format.raw/*190.84*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*191.46*/routes/*191.52*/.Assets.at("javascripts/libs/bootstrap.min.js")),format.raw/*191.99*/(""""></script>
        <script type="text/javascript" src=""""),_display_(/*192.46*/routes/*192.52*/.Assets.at("javascripts/libs/ui-bootstrap-tpls-0.12.0.min.js")),format.raw/*192.114*/(""""></script>
    </body>
</html>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Mar 05 17:30:56 CET 2015
                  SOURCE: /Users/cbi/Documents/git-repos/ART/app/views/index.scala.html
                  HASH: d6034076c4af2fcfe7bb824875946342d6728dae
                  MATRIX: 798->0|1168->344|1182->350|1234->382|1339->460|1354->466|1418->509|1486->550|1501->556|1556->590|2933->1939|2962->1940|2991->1941|3052->1974|3081->1975|3211->2077|3240->2078|3269->2079|3329->2111|3358->2112|3486->2212|3515->2213|3544->2214|3606->2248|3635->2249|3767->2353|3796->2354|3825->2355|3889->2391|3918->2392|5071->3517|5100->3518|5129->3519|5175->3537|5204->3538|5233->3539|5312->3590|5341->3591|5370->3592|5418->3612|5447->3613|5476->3614|5693->3803|5722->3804|5751->3805|5815->3841|5844->3842|7440->5410|7469->5411|7498->5412|7538->5423|7568->5424|7598->5425|7629->5427|7659->5428|7689->5429|7729->5440|7759->5441|7789->5442|7819->5443|8036->5631|8066->5632|8096->5633|8133->5641|8163->5642|8193->5643|8254->5675|8284->5676|8314->5677|8352->5686|8382->5687|8412->5688|8704->5952|8733->5953|8762->5954|8804->5968|8833->5969|8862->5970|8915->5995|9333->6384|9363->6385|9393->6386|9435->6399|9465->6400|9495->6401|9549->6426|13754->10602|13784->10603|13814->10604|13850->10611|13880->10612|13910->10613|13972->10646|14002->10647|14032->10648|14080->10667|14110->10668|14140->10669|14198->10698|15547->12019|15563->12025|15630->12070|15715->12127|15731->12133|15785->12165|15870->12222|15886->12228|15955->12275|16040->12332|16056->12338|16141->12400
                  LINES: 29->1|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|66->38|66->38|66->38|66->38|66->38|67->39|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|84->56|84->56|84->56|84->56|84->56|84->56|85->57|85->57|85->57|85->57|85->57|85->57|87->59|87->59|87->59|87->59|87->59|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|119->91|119->91|119->91|119->91|119->91|119->91|120->92|129->101|129->101|129->101|129->101|129->101|129->101|130->102|181->153|181->153|181->153|181->153|181->153|181->153|182->154|182->154|182->154|182->154|182->154|182->154|183->155|217->189|217->189|217->189|218->190|218->190|218->190|219->191|219->191|219->191|220->192|220->192|220->192
                  -- GENERATED --
              */
          