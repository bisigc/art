// @SOURCE:/Users/cbi/Documents/git-repos/ART/conf/routes
// @HASH:163a2450400457b893c184fbf9e287ffb5c790d1
// @DATE:Wed May 20 22:42:13 CEST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_ar_ArController_getAll1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar"))))
private[this] lazy val controllers_ar_ArController_getAll1_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "getAll", Nil,"GET", """AR service""", Routes.prefix + """ar"""))
        

// @LINE:10
private[this] lazy val controllers_ar_ArController_get2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_ArController_get2_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ar/$id<[^/]+>"""))
        

// @LINE:11
private[this] lazy val controllers_ar_ArController_create3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar"))))
private[this] lazy val controllers_ar_ArController_create3_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "create", Nil,"POST", """""", Routes.prefix + """ar"""))
        

// @LINE:12
private[this] lazy val controllers_ar_ArController_update4_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar"))))
private[this] lazy val controllers_ar_ArController_update4_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "update", Nil,"PUT", """""", Routes.prefix + """ar"""))
        

// @LINE:13
private[this] lazy val controllers_ar_ArController_delete5_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ar/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_ArController_delete5_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """ar/$id<[^/]+>"""))
        

// @LINE:17
private[this] lazy val controllers_ar_ArVersionController_getAll6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion"))))
private[this] lazy val controllers_ar_ArVersionController_getAll6_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "getAll", Nil,"GET", """AR Version service
GET     /arversion/active         @controllers.ar.ArVersionController.getAllActive()""", Routes.prefix + """arversion"""))
        

// @LINE:18
private[this] lazy val controllers_ar_ArVersionController_get7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_ArVersionController_get7_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """arversion/$id<[^/]+>"""))
        

// @LINE:19
private[this] lazy val controllers_ar_ArVersionController_create8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion"))))
private[this] lazy val controllers_ar_ArVersionController_create8_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "create", Nil,"POST", """""", Routes.prefix + """arversion"""))
        

// @LINE:20
private[this] lazy val controllers_ar_ArVersionController_update9_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion"))))
private[this] lazy val controllers_ar_ArVersionController_update9_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "update", Nil,"PUT", """""", Routes.prefix + """arversion"""))
        

// @LINE:21
private[this] lazy val controllers_ar_ArVersionController_delete10_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arversion/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_ArVersionController_delete10_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """arversion/$id<[^/]+>"""))
        

// @LINE:22
private[this] lazy val controllers_ar_ArVersionController_arSmellSearch11_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arsearch"))))
private[this] lazy val controllers_ar_ArVersionController_arSmellSearch11_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).arSmellSearch(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "arSmellSearch", Nil,"POST", """""", Routes.prefix + """arsearch"""))
        

// @LINE:23
private[this] lazy val controllers_ar_ArVersionController_arSmellSearchCount12_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("arsearchcount"))))
private[this] lazy val controllers_ar_ArVersionController_arSmellSearchCount12_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).arSmellSearchCount(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArVersionController", "arSmellSearchCount", Nil,"POST", """""", Routes.prefix + """arsearchcount"""))
        

// @LINE:26
private[this] lazy val controllers_ar_element_ModelElementController_getModelElementLinkType13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement/type"))))
private[this] lazy val controllers_ar_element_ModelElementController_getModelElementLinkType13_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getModelElementLinkType(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "getModelElementLinkType", Nil,"GET", """ModelElement service""", Routes.prefix + """modelelement/type"""))
        

// @LINE:27
private[this] lazy val controllers_ar_element_ModelElementController_getQASElements14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement/qas"))))
private[this] lazy val controllers_ar_element_ModelElementController_getQASElements14_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getQASElements(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "getQASElements", Nil,"GET", """""", Routes.prefix + """modelelement/qas"""))
        

// @LINE:28
private[this] lazy val controllers_ar_element_ModelElementController_getComponentElements15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement/components"))))
private[this] lazy val controllers_ar_element_ModelElementController_getComponentElements15_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getComponentElements(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "getComponentElements", Nil,"GET", """""", Routes.prefix + """modelelement/components"""))
        

// @LINE:29
private[this] lazy val controllers_ar_element_ModelElementController_getContextElements16_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement/context"))))
private[this] lazy val controllers_ar_element_ModelElementController_getContextElements16_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getContextElements(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "getContextElements", Nil,"GET", """""", Routes.prefix + """modelelement/context"""))
        

// @LINE:30
private[this] lazy val controllers_ar_element_ModelElementController_getDecisionElements17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement/decisions"))))
private[this] lazy val controllers_ar_element_ModelElementController_getDecisionElements17_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getDecisionElements(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "getDecisionElements", Nil,"GET", """""", Routes.prefix + """modelelement/decisions"""))
        

// @LINE:31
private[this] lazy val controllers_ar_element_ModelElementController_getDesignElements18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement/design"))))
private[this] lazy val controllers_ar_element_ModelElementController_getDesignElements18_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getDesignElements(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "getDesignElements", Nil,"GET", """""", Routes.prefix + """modelelement/design"""))
        

// @LINE:32
private[this] lazy val controllers_ar_element_ModelElementController_getReferenceElements19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement/references"))))
private[this] lazy val controllers_ar_element_ModelElementController_getReferenceElements19_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getReferenceElements(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "getReferenceElements", Nil,"GET", """""", Routes.prefix + """modelelement/references"""))
        

// @LINE:33
private[this] lazy val controllers_ar_element_ModelElementController_getAll20_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement"))))
private[this] lazy val controllers_ar_element_ModelElementController_getAll20_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "getAll", Nil,"GET", """""", Routes.prefix + """modelelement"""))
        

// @LINE:34
private[this] lazy val controllers_ar_element_ModelElementController_get21_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_element_ModelElementController_get21_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """modelelement/$id<[^/]+>"""))
        

// @LINE:35
private[this] lazy val controllers_ar_element_ModelElementController_create22_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement"))))
private[this] lazy val controllers_ar_element_ModelElementController_create22_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "create", Nil,"POST", """""", Routes.prefix + """modelelement"""))
        

// @LINE:36
private[this] lazy val controllers_ar_element_ModelElementController_update23_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement"))))
private[this] lazy val controllers_ar_element_ModelElementController_update23_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "update", Nil,"PUT", """""", Routes.prefix + """modelelement"""))
        

// @LINE:37
private[this] lazy val controllers_ar_element_ModelElementController_delete24_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modelelement/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_element_ModelElementController_delete24_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.element.ModelElementController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """modelelement/$id<[^/]+>"""))
        

// @LINE:40
private[this] lazy val controllers_smell_SmellController_getAll25_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell"))))
private[this] lazy val controllers_smell_SmellController_getAll25_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getAll", Nil,"GET", """Smell service""", Routes.prefix + """smell"""))
        

// @LINE:41
private[this] lazy val controllers_smell_SmellController_getCloudSmells26_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell/forcloud"))))
private[this] lazy val controllers_smell_SmellController_getCloudSmells26_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getCloudSmells(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "getCloudSmells", Nil,"GET", """""", Routes.prefix + """smell/forcloud"""))
        

// @LINE:42
private[this] lazy val controllers_smell_SmellController_get27_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellController_get27_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """smell/$id<[^/]+>"""))
        

// @LINE:43
private[this] lazy val controllers_smell_SmellController_create28_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell"))))
private[this] lazy val controllers_smell_SmellController_create28_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "create", Nil,"POST", """""", Routes.prefix + """smell"""))
        

// @LINE:44
private[this] lazy val controllers_smell_SmellController_update29_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell"))))
private[this] lazy val controllers_smell_SmellController_update29_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "update", Nil,"PUT", """""", Routes.prefix + """smell"""))
        

// @LINE:45
private[this] lazy val controllers_smell_SmellController_delete30_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smell/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellController_delete30_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """smell/$id<[^/]+>"""))
        

// @LINE:48
private[this] lazy val controllers_smell_SmellGroupController_getAll31_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup"))))
private[this] lazy val controllers_smell_SmellGroupController_getAll31_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "getAll", Nil,"GET", """SmellGroup service""", Routes.prefix + """smellgroup"""))
        

// @LINE:49
private[this] lazy val controllers_smell_SmellGroupController_get32_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellGroupController_get32_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """smellgroup/$id<[^/]+>"""))
        

// @LINE:50
private[this] lazy val controllers_smell_SmellGroupController_create33_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup"))))
private[this] lazy val controllers_smell_SmellGroupController_create33_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "create", Nil,"POST", """""", Routes.prefix + """smellgroup"""))
        

// @LINE:51
private[this] lazy val controllers_smell_SmellGroupController_update34_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup"))))
private[this] lazy val controllers_smell_SmellGroupController_update34_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "update", Nil,"PUT", """""", Routes.prefix + """smellgroup"""))
        

// @LINE:52
private[this] lazy val controllers_smell_SmellGroupController_delete35_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("smellgroup/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_smell_SmellGroupController_delete35_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.smell.SmellGroupController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """smellgroup/$id<[^/]+>"""))
        

// @LINE:55
private[this] lazy val controllers_discussion_DiscussionController_getAll36_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion"))))
private[this] lazy val controllers_discussion_DiscussionController_getAll36_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "getAll", Nil,"GET", """Discussion service""", Routes.prefix + """discussion"""))
        

// @LINE:56
private[this] lazy val controllers_discussion_DiscussionController_get37_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_DiscussionController_get37_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """discussion/$id<[^/]+>"""))
        

// @LINE:57
private[this] lazy val controllers_discussion_DiscussionController_create38_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion"))))
private[this] lazy val controllers_discussion_DiscussionController_create38_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "create", Nil,"POST", """""", Routes.prefix + """discussion"""))
        

// @LINE:58
private[this] lazy val controllers_discussion_DiscussionController_update39_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion"))))
private[this] lazy val controllers_discussion_DiscussionController_update39_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "update", Nil,"PUT", """""", Routes.prefix + """discussion"""))
        

// @LINE:59
private[this] lazy val controllers_discussion_DiscussionController_delete40_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("discussion/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_DiscussionController_delete40_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.DiscussionController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """discussion/$id<[^/]+>"""))
        

// @LINE:62
private[this] lazy val controllers_discussion_CommentController_getAll41_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment"))))
private[this] lazy val controllers_discussion_CommentController_getAll41_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "getAll", Nil,"GET", """Comment service""", Routes.prefix + """comment"""))
        

// @LINE:63
private[this] lazy val controllers_discussion_CommentController_get42_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_CommentController_get42_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """comment/$id<[^/]+>"""))
        

// @LINE:64
private[this] lazy val controllers_discussion_LikeController_like43_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("like/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_LikeController_like43_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.LikeController]).like(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.LikeController", "like", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """like/$id<[^/]+>"""))
        

// @LINE:65
private[this] lazy val controllers_discussion_CommentController_create44_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment"))))
private[this] lazy val controllers_discussion_CommentController_create44_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "create", Nil,"POST", """""", Routes.prefix + """comment"""))
        

// @LINE:66
private[this] lazy val controllers_discussion_CommentController_update45_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment"))))
private[this] lazy val controllers_discussion_CommentController_update45_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "update", Nil,"PUT", """""", Routes.prefix + """comment"""))
        

// @LINE:67
private[this] lazy val controllers_discussion_CommentController_delete46_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_discussion_CommentController_delete46_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.discussion.CommentController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """comment/$id<[^/]+>"""))
        

// @LINE:70
private[this] lazy val controllers_property_PropertyController_getAll47_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_property_PropertyController_getAll47_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getAll", Nil,"GET", """Property service""", Routes.prefix + """property"""))
        

// @LINE:71
private[this] lazy val controllers_property_PropertyController_getCategorie48_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/categorie/"),DynamicPart("cat", """[^/]+""",true))))
private[this] lazy val controllers_property_PropertyController_getCategorie48_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getCategorie(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "getCategorie", Seq(classOf[String]),"GET", """""", Routes.prefix + """property/categorie/$cat<[^/]+>"""))
        

// @LINE:72
private[this] lazy val controllers_property_PropertyController_get49_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_property_PropertyController_get49_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:73
private[this] lazy val controllers_property_PropertyController_create50_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_property_PropertyController_create50_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "create", Nil,"POST", """""", Routes.prefix + """property"""))
        

// @LINE:74
private[this] lazy val controllers_property_PropertyController_update51_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property"))))
private[this] lazy val controllers_property_PropertyController_update51_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "update", Nil,"PUT", """""", Routes.prefix + """property"""))
        

// @LINE:75
private[this] lazy val controllers_property_PropertyController_delete52_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("property/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_property_PropertyController_delete52_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.property.PropertyController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """property/$id<[^/]+>"""))
        

// @LINE:78
private[this] lazy val controllers_menu_MenuController_getAll53_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_menu_MenuController_getAll53_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "getAll", Nil,"GET", """Menu service""", Routes.prefix + """menu"""))
        

// @LINE:79
private[this] lazy val controllers_menu_MenuController_get54_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_menu_MenuController_get54_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """menu/$id<[^/]+>"""))
        

// @LINE:80
private[this] lazy val controllers_menu_MenuController_create55_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_menu_MenuController_create55_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "create", Nil,"POST", """""", Routes.prefix + """menu"""))
        

// @LINE:81
private[this] lazy val controllers_menu_MenuController_update56_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu"))))
private[this] lazy val controllers_menu_MenuController_update56_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "update", Nil,"PUT", """""", Routes.prefix + """menu"""))
        

// @LINE:82
private[this] lazy val controllers_menu_MenuController_delete57_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("menu/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_menu_MenuController_delete57_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.menu.MenuController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """menu/$id<[^/]+>"""))
        

// @LINE:85
private[this] lazy val controllers_user_UserController_getAll58_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_user_UserController_getAll58_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "getAll", Nil,"GET", """User service""", Routes.prefix + """user"""))
        

// @LINE:86
private[this] lazy val controllers_user_UserController_get59_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_user_UserController_get59_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """user/$id<[^/]+>"""))
        

// @LINE:87
private[this] lazy val controllers_user_UserController_create60_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_user_UserController_create60_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "create", Nil,"POST", """""", Routes.prefix + """user"""))
        

// @LINE:88
private[this] lazy val controllers_user_UserController_update61_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
private[this] lazy val controllers_user_UserController_update61_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "update", Nil,"PUT", """""", Routes.prefix + """user"""))
        

// @LINE:89
private[this] lazy val controllers_user_UserController_delete62_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_user_UserController_delete62_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """user/$id<[^/]+>"""))
        

// @LINE:90
private[this] lazy val controllers_user_UserController_changePassword63_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("changepw"))))
private[this] lazy val controllers_user_UserController_changePassword63_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).changePassword(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "changePassword", Nil,"PUT", """""", Routes.prefix + """changepw"""))
        

// @LINE:91
private[this] lazy val controllers_user_UserController_login64_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_user_UserController_login64_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "login", Nil,"PUT", """""", Routes.prefix + """login"""))
        

// @LINE:92
private[this] lazy val controllers_user_UserController_logout65_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_user_UserController_logout65_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).logout(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:93
private[this] lazy val controllers_user_RoleController_getAll66_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userroles"))))
private[this] lazy val controllers_user_RoleController_getAll66_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.RoleController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.RoleController", "getAll", Nil,"GET", """""", Routes.prefix + """userroles"""))
        

// @LINE:94
private[this] lazy val controllers_user_UserController_uploadAvatar67_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("avatar"))))
private[this] lazy val controllers_user_UserController_uploadAvatar67_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).uploadAvatar(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "uploadAvatar", Nil,"POST", """""", Routes.prefix + """avatar"""))
        

// @LINE:95
private[this] lazy val controllers_user_UserController_getAvatar68_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("avatar/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_user_UserController_getAvatar68_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAvatar(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.user.UserController", "getAvatar", Seq(classOf[Long]),"GET", """""", Routes.prefix + """avatar/$id<[^/]+>"""))
        

// @LINE:98
private[this] lazy val controllers_ar_ArSearchController_getUserSearches69_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("usersearch"))))
private[this] lazy val controllers_ar_ArSearchController_getUserSearches69_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArSearchController]).getUserSearches(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArSearchController", "getUserSearches", Nil,"GET", """User Searches""", Routes.prefix + """usersearch"""))
        

// @LINE:99
private[this] lazy val controllers_ar_ArSearchController_create70_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("usersearch"))))
private[this] lazy val controllers_ar_ArSearchController_create70_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArSearchController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArSearchController", "create", Nil,"POST", """""", Routes.prefix + """usersearch"""))
        

// @LINE:100
private[this] lazy val controllers_ar_ArSearchController_delete71_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("usersearch/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ar_ArSearchController_delete71_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArSearchController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ar.ArSearchController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """usersearch/$id<[^/]+>"""))
        

// @LINE:103
private[this] lazy val controllers_task_TaskTemplateController_getAll72_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task"))))
private[this] lazy val controllers_task_TaskTemplateController_getAll72_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "getAll", Nil,"GET", """TaskTemplate service""", Routes.prefix + """task"""))
        

// @LINE:104
private[this] lazy val controllers_task_TaskTemplateController_get73_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_TaskTemplateController_get73_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """task/$id<[^/]+>"""))
        

// @LINE:105
private[this] lazy val controllers_task_TaskTemplateController_create74_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task"))))
private[this] lazy val controllers_task_TaskTemplateController_create74_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "create", Nil,"POST", """""", Routes.prefix + """task"""))
        

// @LINE:106
private[this] lazy val controllers_task_TaskTemplateController_update75_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task"))))
private[this] lazy val controllers_task_TaskTemplateController_update75_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "update", Nil,"PUT", """""", Routes.prefix + """task"""))
        

// @LINE:107
private[this] lazy val controllers_task_TaskTemplateController_delete76_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_TaskTemplateController_delete76_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskTemplateController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """task/$id<[^/]+>"""))
        

// @LINE:110
private[this] lazy val controllers_task_TaskPropertyController_getAll77_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("taskproperty"))))
private[this] lazy val controllers_task_TaskPropertyController_getAll77_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "getAll", Nil,"GET", """TaskProperty service""", Routes.prefix + """taskproperty"""))
        

// @LINE:111
private[this] lazy val controllers_task_TaskPropertyController_get78_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("taskproperty/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_TaskPropertyController_get78_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """taskproperty/$id<[^/]+>"""))
        

// @LINE:112
private[this] lazy val controllers_task_TaskPropertyController_create79_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("taskproperty"))))
private[this] lazy val controllers_task_TaskPropertyController_create79_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "create", Nil,"POST", """""", Routes.prefix + """taskproperty"""))
        

// @LINE:113
private[this] lazy val controllers_task_TaskPropertyController_update80_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("taskproperty"))))
private[this] lazy val controllers_task_TaskPropertyController_update80_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "update", Nil,"PUT", """""", Routes.prefix + """taskproperty"""))
        

// @LINE:114
private[this] lazy val controllers_task_TaskPropertyController_delete81_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("taskproperty/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_TaskPropertyController_delete81_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.TaskPropertyController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """taskproperty/$id<[^/]+>"""))
        

// @LINE:117
private[this] lazy val controllers_task_ExecTaskTypeController_getAll82_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype"))))
private[this] lazy val controllers_task_ExecTaskTypeController_getAll82_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getAll(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getAll", Nil,"GET", """ExecTaskType service""", Routes.prefix + """exectasktype"""))
        

// @LINE:118
private[this] lazy val controllers_task_ExecTaskTypeController_getEmptyExecTaskType83_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype/empty"))))
private[this] lazy val controllers_task_ExecTaskTypeController_getEmptyExecTaskType83_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getEmptyExecTaskType(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "getEmptyExecTaskType", Nil,"GET", """""", Routes.prefix + """exectasktype/empty"""))
        

// @LINE:119
private[this] lazy val controllers_task_ExecTaskTypeController_get84_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_ExecTaskTypeController_get84_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).get(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "get", Seq(classOf[Long]),"GET", """""", Routes.prefix + """exectasktype/$id<[^/]+>"""))
        

// @LINE:120
private[this] lazy val controllers_task_ExecTaskTypeController_create85_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype"))))
private[this] lazy val controllers_task_ExecTaskTypeController_create85_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "create", Nil,"POST", """""", Routes.prefix + """exectasktype"""))
        

// @LINE:121
private[this] lazy val controllers_task_ExecTaskTypeController_update86_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype"))))
private[this] lazy val controllers_task_ExecTaskTypeController_update86_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).update(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "update", Nil,"PUT", """""", Routes.prefix + """exectasktype"""))
        

// @LINE:122
private[this] lazy val controllers_task_ExecTaskTypeController_delete87_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("exectasktype/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_task_ExecTaskTypeController_delete87_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.task.ExecTaskTypeController", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """exectasktype/$id<[^/]+>"""))
        

// @LINE:125
private[this] lazy val controllers_status_StatusController_get88_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("status"))))
private[this] lazy val controllers_status_StatusController_get88_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.status.StatusController]).get(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.status.StatusController", "get", Nil,"GET", """Status service""", Routes.prefix + """status"""))
        

// @LINE:128
private[this] lazy val controllers_statistic_StatisticController_get89_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("stats"))))
private[this] lazy val controllers_statistic_StatisticController_get89_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.statistic.StatisticController]).get(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.statistic.StatisticController", "get", Nil,"GET", """Statistic service""", Routes.prefix + """stats"""))
        

// @LINE:131
private[this] lazy val controllers_Assets_at90_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at90_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""@controllers.Application@.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar""","""@controllers.ar.ArController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar/$id<[^/]+>""","""@controllers.ar.ArController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar""","""@controllers.ar.ArController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar""","""@controllers.ar.ArController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ar/$id<[^/]+>""","""@controllers.ar.ArController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion""","""@controllers.ar.ArVersionController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion/$id<[^/]+>""","""@controllers.ar.ArVersionController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion""","""@controllers.ar.ArVersionController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion""","""@controllers.ar.ArVersionController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arversion/$id<[^/]+>""","""@controllers.ar.ArVersionController@.delete(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arsearch""","""@controllers.ar.ArVersionController@.arSmellSearch()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """arsearchcount""","""@controllers.ar.ArVersionController@.arSmellSearchCount()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement/type""","""@controllers.ar.element.ModelElementController@.getModelElementLinkType()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement/qas""","""@controllers.ar.element.ModelElementController@.getQASElements()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement/components""","""@controllers.ar.element.ModelElementController@.getComponentElements()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement/context""","""@controllers.ar.element.ModelElementController@.getContextElements()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement/decisions""","""@controllers.ar.element.ModelElementController@.getDecisionElements()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement/design""","""@controllers.ar.element.ModelElementController@.getDesignElements()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement/references""","""@controllers.ar.element.ModelElementController@.getReferenceElements()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement""","""@controllers.ar.element.ModelElementController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement/$id<[^/]+>""","""@controllers.ar.element.ModelElementController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement""","""@controllers.ar.element.ModelElementController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement""","""@controllers.ar.element.ModelElementController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modelelement/$id<[^/]+>""","""@controllers.ar.element.ModelElementController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell""","""@controllers.smell.SmellController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell/forcloud""","""@controllers.smell.SmellController@.getCloudSmells()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell/$id<[^/]+>""","""@controllers.smell.SmellController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell""","""@controllers.smell.SmellController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell""","""@controllers.smell.SmellController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smell/$id<[^/]+>""","""@controllers.smell.SmellController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup""","""@controllers.smell.SmellGroupController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup/$id<[^/]+>""","""@controllers.smell.SmellGroupController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup""","""@controllers.smell.SmellGroupController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup""","""@controllers.smell.SmellGroupController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """smellgroup/$id<[^/]+>""","""@controllers.smell.SmellGroupController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion""","""@controllers.discussion.DiscussionController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion/$id<[^/]+>""","""@controllers.discussion.DiscussionController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion""","""@controllers.discussion.DiscussionController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion""","""@controllers.discussion.DiscussionController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """discussion/$id<[^/]+>""","""@controllers.discussion.DiscussionController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment""","""@controllers.discussion.CommentController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/$id<[^/]+>""","""@controllers.discussion.CommentController@.get(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """like/$id<[^/]+>""","""@controllers.discussion.LikeController@.like(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment""","""@controllers.discussion.CommentController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment""","""@controllers.discussion.CommentController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/$id<[^/]+>""","""@controllers.discussion.CommentController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""@controllers.property.PropertyController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/categorie/$cat<[^/]+>""","""@controllers.property.PropertyController@.getCategorie(cat:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""@controllers.property.PropertyController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""@controllers.property.PropertyController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property""","""@controllers.property.PropertyController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """property/$id<[^/]+>""","""@controllers.property.PropertyController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""@controllers.menu.MenuController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/$id<[^/]+>""","""@controllers.menu.MenuController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""@controllers.menu.MenuController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu""","""@controllers.menu.MenuController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """menu/$id<[^/]+>""","""@controllers.menu.MenuController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.user.UserController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>""","""@controllers.user.UserController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.user.UserController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""@controllers.user.UserController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>""","""@controllers.user.UserController@.delete(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """changepw""","""@controllers.user.UserController@.changePassword()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""@controllers.user.UserController@.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""@controllers.user.UserController@.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userroles""","""@controllers.user.RoleController@.getAll()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """avatar""","""@controllers.user.UserController@.uploadAvatar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """avatar/$id<[^/]+>""","""@controllers.user.UserController@.getAvatar(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """usersearch""","""@controllers.ar.ArSearchController@.getUserSearches()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """usersearch""","""@controllers.ar.ArSearchController@.create()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """usersearch/$id<[^/]+>""","""@controllers.ar.ArSearchController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task""","""@controllers.task.TaskTemplateController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task/$id<[^/]+>""","""@controllers.task.TaskTemplateController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task""","""@controllers.task.TaskTemplateController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task""","""@controllers.task.TaskTemplateController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task/$id<[^/]+>""","""@controllers.task.TaskTemplateController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """taskproperty""","""@controllers.task.TaskPropertyController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """taskproperty/$id<[^/]+>""","""@controllers.task.TaskPropertyController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """taskproperty""","""@controllers.task.TaskPropertyController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """taskproperty""","""@controllers.task.TaskPropertyController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """taskproperty/$id<[^/]+>""","""@controllers.task.TaskPropertyController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype""","""@controllers.task.ExecTaskTypeController@.getAll()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype/empty""","""@controllers.task.ExecTaskTypeController@.getEmptyExecTaskType()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype/$id<[^/]+>""","""@controllers.task.ExecTaskTypeController@.get(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype""","""@controllers.task.ExecTaskTypeController@.create()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype""","""@controllers.task.ExecTaskTypeController@.update()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """exectasktype/$id<[^/]+>""","""@controllers.task.ExecTaskTypeController@.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """status""","""@controllers.status.StatusController@.get()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stats""","""@controllers.statistic.StatisticController@.get()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index())
   }
}
        

// @LINE:9
case controllers_ar_ArController_getAll1_route(params) => {
   call { 
        controllers_ar_ArController_getAll1_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).getAll())
   }
}
        

// @LINE:10
case controllers_ar_ArController_get2_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_ArController_get2_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).get(id))
   }
}
        

// @LINE:11
case controllers_ar_ArController_create3_route(params) => {
   call { 
        controllers_ar_ArController_create3_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).create())
   }
}
        

// @LINE:12
case controllers_ar_ArController_update4_route(params) => {
   call { 
        controllers_ar_ArController_update4_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).update())
   }
}
        

// @LINE:13
case controllers_ar_ArController_delete5_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_ArController_delete5_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArController]).delete(id))
   }
}
        

// @LINE:17
case controllers_ar_ArVersionController_getAll6_route(params) => {
   call { 
        controllers_ar_ArVersionController_getAll6_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).getAll())
   }
}
        

// @LINE:18
case controllers_ar_ArVersionController_get7_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_ArVersionController_get7_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).get(id))
   }
}
        

// @LINE:19
case controllers_ar_ArVersionController_create8_route(params) => {
   call { 
        controllers_ar_ArVersionController_create8_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).create())
   }
}
        

// @LINE:20
case controllers_ar_ArVersionController_update9_route(params) => {
   call { 
        controllers_ar_ArVersionController_update9_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).update())
   }
}
        

// @LINE:21
case controllers_ar_ArVersionController_delete10_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_ArVersionController_delete10_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).delete(id))
   }
}
        

// @LINE:22
case controllers_ar_ArVersionController_arSmellSearch11_route(params) => {
   call { 
        controllers_ar_ArVersionController_arSmellSearch11_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).arSmellSearch())
   }
}
        

// @LINE:23
case controllers_ar_ArVersionController_arSmellSearchCount12_route(params) => {
   call { 
        controllers_ar_ArVersionController_arSmellSearchCount12_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArVersionController]).arSmellSearchCount())
   }
}
        

// @LINE:26
case controllers_ar_element_ModelElementController_getModelElementLinkType13_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_getModelElementLinkType13_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getModelElementLinkType())
   }
}
        

// @LINE:27
case controllers_ar_element_ModelElementController_getQASElements14_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_getQASElements14_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getQASElements())
   }
}
        

// @LINE:28
case controllers_ar_element_ModelElementController_getComponentElements15_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_getComponentElements15_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getComponentElements())
   }
}
        

// @LINE:29
case controllers_ar_element_ModelElementController_getContextElements16_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_getContextElements16_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getContextElements())
   }
}
        

// @LINE:30
case controllers_ar_element_ModelElementController_getDecisionElements17_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_getDecisionElements17_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getDecisionElements())
   }
}
        

// @LINE:31
case controllers_ar_element_ModelElementController_getDesignElements18_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_getDesignElements18_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getDesignElements())
   }
}
        

// @LINE:32
case controllers_ar_element_ModelElementController_getReferenceElements19_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_getReferenceElements19_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getReferenceElements())
   }
}
        

// @LINE:33
case controllers_ar_element_ModelElementController_getAll20_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_getAll20_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).getAll())
   }
}
        

// @LINE:34
case controllers_ar_element_ModelElementController_get21_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_element_ModelElementController_get21_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).get(id))
   }
}
        

// @LINE:35
case controllers_ar_element_ModelElementController_create22_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_create22_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).create())
   }
}
        

// @LINE:36
case controllers_ar_element_ModelElementController_update23_route(params) => {
   call { 
        controllers_ar_element_ModelElementController_update23_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).update())
   }
}
        

// @LINE:37
case controllers_ar_element_ModelElementController_delete24_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_element_ModelElementController_delete24_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.element.ModelElementController]).delete(id))
   }
}
        

// @LINE:40
case controllers_smell_SmellController_getAll25_route(params) => {
   call { 
        controllers_smell_SmellController_getAll25_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getAll())
   }
}
        

// @LINE:41
case controllers_smell_SmellController_getCloudSmells26_route(params) => {
   call { 
        controllers_smell_SmellController_getCloudSmells26_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).getCloudSmells())
   }
}
        

// @LINE:42
case controllers_smell_SmellController_get27_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellController_get27_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).get(id))
   }
}
        

// @LINE:43
case controllers_smell_SmellController_create28_route(params) => {
   call { 
        controllers_smell_SmellController_create28_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).create())
   }
}
        

// @LINE:44
case controllers_smell_SmellController_update29_route(params) => {
   call { 
        controllers_smell_SmellController_update29_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).update())
   }
}
        

// @LINE:45
case controllers_smell_SmellController_delete30_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellController_delete30_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellController]).delete(id))
   }
}
        

// @LINE:48
case controllers_smell_SmellGroupController_getAll31_route(params) => {
   call { 
        controllers_smell_SmellGroupController_getAll31_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).getAll())
   }
}
        

// @LINE:49
case controllers_smell_SmellGroupController_get32_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellGroupController_get32_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).get(id))
   }
}
        

// @LINE:50
case controllers_smell_SmellGroupController_create33_route(params) => {
   call { 
        controllers_smell_SmellGroupController_create33_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).create())
   }
}
        

// @LINE:51
case controllers_smell_SmellGroupController_update34_route(params) => {
   call { 
        controllers_smell_SmellGroupController_update34_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).update())
   }
}
        

// @LINE:52
case controllers_smell_SmellGroupController_delete35_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_smell_SmellGroupController_delete35_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.smell.SmellGroupController]).delete(id))
   }
}
        

// @LINE:55
case controllers_discussion_DiscussionController_getAll36_route(params) => {
   call { 
        controllers_discussion_DiscussionController_getAll36_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).getAll())
   }
}
        

// @LINE:56
case controllers_discussion_DiscussionController_get37_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_DiscussionController_get37_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).get(id))
   }
}
        

// @LINE:57
case controllers_discussion_DiscussionController_create38_route(params) => {
   call { 
        controllers_discussion_DiscussionController_create38_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).create())
   }
}
        

// @LINE:58
case controllers_discussion_DiscussionController_update39_route(params) => {
   call { 
        controllers_discussion_DiscussionController_update39_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).update())
   }
}
        

// @LINE:59
case controllers_discussion_DiscussionController_delete40_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_DiscussionController_delete40_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.DiscussionController]).delete(id))
   }
}
        

// @LINE:62
case controllers_discussion_CommentController_getAll41_route(params) => {
   call { 
        controllers_discussion_CommentController_getAll41_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).getAll())
   }
}
        

// @LINE:63
case controllers_discussion_CommentController_get42_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_CommentController_get42_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).get(id))
   }
}
        

// @LINE:64
case controllers_discussion_LikeController_like43_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_LikeController_like43_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.LikeController]).like(id))
   }
}
        

// @LINE:65
case controllers_discussion_CommentController_create44_route(params) => {
   call { 
        controllers_discussion_CommentController_create44_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).create())
   }
}
        

// @LINE:66
case controllers_discussion_CommentController_update45_route(params) => {
   call { 
        controllers_discussion_CommentController_update45_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).update())
   }
}
        

// @LINE:67
case controllers_discussion_CommentController_delete46_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_discussion_CommentController_delete46_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.discussion.CommentController]).delete(id))
   }
}
        

// @LINE:70
case controllers_property_PropertyController_getAll47_route(params) => {
   call { 
        controllers_property_PropertyController_getAll47_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getAll())
   }
}
        

// @LINE:71
case controllers_property_PropertyController_getCategorie48_route(params) => {
   call(params.fromPath[String]("cat", None)) { (cat) =>
        controllers_property_PropertyController_getCategorie48_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).getCategorie(cat))
   }
}
        

// @LINE:72
case controllers_property_PropertyController_get49_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_property_PropertyController_get49_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).get(id))
   }
}
        

// @LINE:73
case controllers_property_PropertyController_create50_route(params) => {
   call { 
        controllers_property_PropertyController_create50_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).create())
   }
}
        

// @LINE:74
case controllers_property_PropertyController_update51_route(params) => {
   call { 
        controllers_property_PropertyController_update51_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).update())
   }
}
        

// @LINE:75
case controllers_property_PropertyController_delete52_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_property_PropertyController_delete52_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.property.PropertyController]).delete(id))
   }
}
        

// @LINE:78
case controllers_menu_MenuController_getAll53_route(params) => {
   call { 
        controllers_menu_MenuController_getAll53_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).getAll())
   }
}
        

// @LINE:79
case controllers_menu_MenuController_get54_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_menu_MenuController_get54_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).get(id))
   }
}
        

// @LINE:80
case controllers_menu_MenuController_create55_route(params) => {
   call { 
        controllers_menu_MenuController_create55_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).create())
   }
}
        

// @LINE:81
case controllers_menu_MenuController_update56_route(params) => {
   call { 
        controllers_menu_MenuController_update56_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).update())
   }
}
        

// @LINE:82
case controllers_menu_MenuController_delete57_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_menu_MenuController_delete57_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.menu.MenuController]).delete(id))
   }
}
        

// @LINE:85
case controllers_user_UserController_getAll58_route(params) => {
   call { 
        controllers_user_UserController_getAll58_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAll())
   }
}
        

// @LINE:86
case controllers_user_UserController_get59_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_user_UserController_get59_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).get(id))
   }
}
        

// @LINE:87
case controllers_user_UserController_create60_route(params) => {
   call { 
        controllers_user_UserController_create60_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).create())
   }
}
        

// @LINE:88
case controllers_user_UserController_update61_route(params) => {
   call { 
        controllers_user_UserController_update61_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).update())
   }
}
        

// @LINE:89
case controllers_user_UserController_delete62_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_user_UserController_delete62_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).delete(id))
   }
}
        

// @LINE:90
case controllers_user_UserController_changePassword63_route(params) => {
   call { 
        controllers_user_UserController_changePassword63_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).changePassword())
   }
}
        

// @LINE:91
case controllers_user_UserController_login64_route(params) => {
   call { 
        controllers_user_UserController_login64_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).login())
   }
}
        

// @LINE:92
case controllers_user_UserController_logout65_route(params) => {
   call { 
        controllers_user_UserController_logout65_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).logout())
   }
}
        

// @LINE:93
case controllers_user_RoleController_getAll66_route(params) => {
   call { 
        controllers_user_RoleController_getAll66_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.RoleController]).getAll())
   }
}
        

// @LINE:94
case controllers_user_UserController_uploadAvatar67_route(params) => {
   call { 
        controllers_user_UserController_uploadAvatar67_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).uploadAvatar())
   }
}
        

// @LINE:95
case controllers_user_UserController_getAvatar68_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_user_UserController_getAvatar68_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.user.UserController]).getAvatar(id))
   }
}
        

// @LINE:98
case controllers_ar_ArSearchController_getUserSearches69_route(params) => {
   call { 
        controllers_ar_ArSearchController_getUserSearches69_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArSearchController]).getUserSearches())
   }
}
        

// @LINE:99
case controllers_ar_ArSearchController_create70_route(params) => {
   call { 
        controllers_ar_ArSearchController_create70_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArSearchController]).create())
   }
}
        

// @LINE:100
case controllers_ar_ArSearchController_delete71_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ar_ArSearchController_delete71_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ar.ArSearchController]).delete(id))
   }
}
        

// @LINE:103
case controllers_task_TaskTemplateController_getAll72_route(params) => {
   call { 
        controllers_task_TaskTemplateController_getAll72_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).getAll())
   }
}
        

// @LINE:104
case controllers_task_TaskTemplateController_get73_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_TaskTemplateController_get73_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).get(id))
   }
}
        

// @LINE:105
case controllers_task_TaskTemplateController_create74_route(params) => {
   call { 
        controllers_task_TaskTemplateController_create74_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).create())
   }
}
        

// @LINE:106
case controllers_task_TaskTemplateController_update75_route(params) => {
   call { 
        controllers_task_TaskTemplateController_update75_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).update())
   }
}
        

// @LINE:107
case controllers_task_TaskTemplateController_delete76_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_TaskTemplateController_delete76_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskTemplateController]).delete(id))
   }
}
        

// @LINE:110
case controllers_task_TaskPropertyController_getAll77_route(params) => {
   call { 
        controllers_task_TaskPropertyController_getAll77_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).getAll())
   }
}
        

// @LINE:111
case controllers_task_TaskPropertyController_get78_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_TaskPropertyController_get78_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).get(id))
   }
}
        

// @LINE:112
case controllers_task_TaskPropertyController_create79_route(params) => {
   call { 
        controllers_task_TaskPropertyController_create79_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).create())
   }
}
        

// @LINE:113
case controllers_task_TaskPropertyController_update80_route(params) => {
   call { 
        controllers_task_TaskPropertyController_update80_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).update())
   }
}
        

// @LINE:114
case controllers_task_TaskPropertyController_delete81_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_TaskPropertyController_delete81_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.TaskPropertyController]).delete(id))
   }
}
        

// @LINE:117
case controllers_task_ExecTaskTypeController_getAll82_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_getAll82_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getAll())
   }
}
        

// @LINE:118
case controllers_task_ExecTaskTypeController_getEmptyExecTaskType83_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_getEmptyExecTaskType83_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).getEmptyExecTaskType())
   }
}
        

// @LINE:119
case controllers_task_ExecTaskTypeController_get84_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_ExecTaskTypeController_get84_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).get(id))
   }
}
        

// @LINE:120
case controllers_task_ExecTaskTypeController_create85_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_create85_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).create())
   }
}
        

// @LINE:121
case controllers_task_ExecTaskTypeController_update86_route(params) => {
   call { 
        controllers_task_ExecTaskTypeController_update86_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).update())
   }
}
        

// @LINE:122
case controllers_task_ExecTaskTypeController_delete87_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_task_ExecTaskTypeController_delete87_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.task.ExecTaskTypeController]).delete(id))
   }
}
        

// @LINE:125
case controllers_status_StatusController_get88_route(params) => {
   call { 
        controllers_status_StatusController_get88_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.status.StatusController]).get())
   }
}
        

// @LINE:128
case controllers_statistic_StatisticController_get89_route(params) => {
   call { 
        controllers_statistic_StatisticController_get89_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.statistic.StatisticController]).get())
   }
}
        

// @LINE:131
case controllers_Assets_at90_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at90_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     