package tracer;

public class TracerBenchmark extends tracer.BenchmarkBase implements tracer.TracerBenchmark_interface
{
    public static dart._runtime.types.simple.InterfaceTypeInfo dart2java$typeInfo = new dart._runtime.types.simple.InterfaceTypeInfo(tracer.TracerBenchmark.class, tracer.TracerBenchmark_interface.class);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_BenchmarkBase = new dart._runtime.types.simple.InterfaceTypeExpr(tracer.BenchmarkBase.dart2java$typeInfo);
    static {
      tracer.TracerBenchmark.dart2java$typeInfo.superclass = dart2java$typeExpr_BenchmarkBase;
    }
  
    public TracerBenchmark(dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker arg, dart._runtime.types.simple.Type type)
    {
      super(arg, type);
    }
  
    public void warmup()
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      tracer.__TopLevel.renderScene(null);
    }
    public void exercise()
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      tracer.__TopLevel.renderScene(null);
    }
    public void _constructor()
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      super._constructor("Tracer");
    }
    public static tracer.TracerBenchmark_interface _new(dart._runtime.types.simple.Type type)
    {
      tracer.TracerBenchmark_interface result;
      result = new tracer.TracerBenchmark(((dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker) null), type);
      result._constructor();
      return result;
    }
}
