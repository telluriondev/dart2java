package is_operator_test;

public class A extends dart._runtime.base.DartObject implements is_operator_test.A_interface, is_operator_test.AI_interface
{
    public static dart._runtime.types.simple.InterfaceTypeInfo dart2java$typeInfo = new dart._runtime.types.simple.InterfaceTypeInfo(is_operator_test.A.class, is_operator_test.A_interface.class);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Object = new dart._runtime.types.simple.InterfaceTypeExpr(dart._runtime.helpers.ObjectHelper.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_AI = new dart._runtime.types.simple.InterfaceTypeExpr(is_operator_test.AI.dart2java$typeInfo);
    static {
      is_operator_test.A.dart2java$typeInfo.superclass = dart2java$typeExpr_Object;
      is_operator_test.A.dart2java$typeInfo.interfaces = new dart._runtime.types.simple.InterfaceTypeExpr[] {dart2java$typeExpr_AI};
    }
  
    public A(dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker arg, dart._runtime.types.simple.Type type)
    {
      super(arg, type);
    }
  
    public void _constructor()
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      super._constructor();
    }
    public static is_operator_test.A_interface _new(dart._runtime.types.simple.Type type)
    {
      is_operator_test.A_interface result;
      result = new is_operator_test.A(((dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker) null), type);
      result._constructor();
      return result;
    }
}
