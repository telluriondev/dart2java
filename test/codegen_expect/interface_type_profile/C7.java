package interface_type_profile;

public class C7 extends dart._runtime.base.DartObject implements interface_type_profile.C7_interface, interface_type_profile.B7_interface, interface_type_profile.B8_interface
{
    public static dart._runtime.types.simple.InterfaceTypeInfo dart2java$typeInfo = new dart._runtime.types.simple.InterfaceTypeInfo(interface_type_profile.C7.class, interface_type_profile.C7_interface.class);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_Object = new dart._runtime.types.simple.InterfaceTypeExpr(dart._runtime.helpers.ObjectHelper.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_B7 = new dart._runtime.types.simple.InterfaceTypeExpr(interface_type_profile.B7.dart2java$typeInfo);
    private static dart._runtime.types.simple.InterfaceTypeExpr dart2java$typeExpr_B8 = new dart._runtime.types.simple.InterfaceTypeExpr(interface_type_profile.B8.dart2java$typeInfo);
    static {
      interface_type_profile.C7.dart2java$typeInfo.superclass = dart2java$typeExpr_Object;
      interface_type_profile.C7.dart2java$typeInfo.interfaces = new dart._runtime.types.simple.InterfaceTypeExpr[] {dart2java$typeExpr_B7, dart2java$typeExpr_B8};
    }
  
    public C7(dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker arg, dart._runtime.types.simple.Type type)
    {
      super(arg, type);
    }
  
    public void _constructor()
    {
      final dart._runtime.types.simple.TypeEnvironment dart2java$localTypeEnv = this.dart2java$type.env;
      super._constructor();
    }
    public static interface_type_profile.C7_interface _new(dart._runtime.types.simple.Type type)
    {
      interface_type_profile.C7_interface result;
      result = new interface_type_profile.C7(((dart._runtime.helpers.ConstructorHelper.EmptyConstructorMarker) null), type);
      result._constructor();
      return result;
    }
}
