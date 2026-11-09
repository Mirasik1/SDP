package visitor;

public interface IFilamentVisitor {
    void visit(PlaFilament pla);
    void visit(PetgFilament petg);
    void visit(TpuFilament tpu);
}
