package tracer;

public class __TopLevel
{
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_TracerBenchmark = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.TracerBenchmark.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Scene = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Scene.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Vector = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Vector.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Camera = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Camera.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Color = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Color.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Background = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Background.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Solid = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Solid.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Sphere = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Sphere.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Chessboard = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Chessboard.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Plane = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Plane.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Light = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Light.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Engine = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.Engine.dart2java$typeInfo);
    public static java.lang.Object checkNumber;
  
  
  
    public static void main(String[] args)
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = dart._runtime.types.simple.TypeEnvironment.ROOT;
      dart.core.__TopLevel.print("Running benchmark...");
      tracer.TracerBenchmark._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_TracerBenchmark)).report();
      dart.core.__TopLevel.print("Done.");
    }
    public static void renderScene(java.lang.Object event)
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = dart._runtime.types.simple.TypeEnvironment.ROOT;
      tracer.Scene_interface scene = tracer.Scene._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Scene));
      scene.setCamera(tracer.Camera._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Camera), tracer.Vector._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Vector), 0.0, 0.0, (-15.0)), tracer.Vector._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Vector), (-0.2), 0.0, 5.0), tracer.Vector._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Vector), 0.0, 1.0, 0.0)));
      scene.setBackground(tracer.Background._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Background), tracer.Color._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Color), 0.5, 0.5, 0.5), 0.4));
      tracer.Sphere_interface sphere = tracer.Sphere._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Sphere), tracer.Vector._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Vector), (-1.5), 1.5, 2.0), 1.5, tracer.Solid._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Solid), tracer.Color._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Color), 0.0, 0.5, 0.5), 0.3, 0.0, 0.0, 2.0));
      tracer.Sphere_interface sphere1 = tracer.Sphere._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Sphere), tracer.Vector._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Vector), 1.0, 0.25, 1.0), 0.5, tracer.Solid._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Solid), tracer.Color._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Color), 0.9, 0.9, 0.9), 0.1, 0.0, 0.0, 1.5));
      tracer.Plane_interface plane = tracer.Plane._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Plane), tracer.Vector._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Vector), 0.1, 0.9, (-0.5)).normalize(), 1.2, tracer.Chessboard._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Chessboard), tracer.Color._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Color), 1.0, 1.0, 1.0), tracer.Color._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Color), 0.0, 0.0, 0.0), 0.2, 0.0, 1.0, 0.7));
      dart._runtime.helpers.DynamicHelper.invoke("add", scene.getShapes(), plane);
      dart._runtime.helpers.DynamicHelper.invoke("add", scene.getShapes(), sphere);
      dart._runtime.helpers.DynamicHelper.invoke("add", scene.getShapes(), sphere1);
      tracer.Light_interface light = tracer.Light._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Light), tracer.Vector._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Vector), 5.0, 10.0, (-1.0)), tracer.Color._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Color), 0.8, 0.8, 0.8), 10.0);
      tracer.Light_interface light1 = tracer.Light._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Light), tracer.Vector._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Vector), (-3.0), 5.0, (-15.0)), tracer.Color._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Color), 0.8, 0.8, 0.8), 100.0);
      dart._runtime.helpers.DynamicHelper.invoke("add", scene.getLights(), light);
      dart._runtime.helpers.DynamicHelper.invoke("add", scene.getLights(), light1);
      int imageWidth = 0;
      int imageHeight = 0;
      int pixelSize = 0;
      boolean renderDiffuse = false;
      boolean renderShadows = false;
      boolean renderHighlights = false;
      boolean renderReflections = false;
      java.lang.Object canvas = null;
      if (dart._runtime.helpers.ObjectHelper.operatorEqual(event, null))
      {
        imageWidth = 100;
        imageHeight = 100;
        pixelSize = 5;
        renderDiffuse = true;
        renderShadows = true;
        renderHighlights = true;
        renderReflections = true;
        canvas = null;
      }
      else
      {
        
      }
      int rayDepth = 2;
      tracer.Engine_interface raytracer = tracer.Engine._new(dart2java$localTypeEnv.evaluate(dart2java$typeExpr_Engine), imageWidth, imageHeight, pixelSize, pixelSize, renderDiffuse, renderShadows, renderHighlights, renderReflections, rayDepth);
      raytracer.renderScene(scene, canvas);
    }
}
