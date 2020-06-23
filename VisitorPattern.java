package visitor;
import java.util.*;
public class VisitorPattern
{
    public static void main(String[] args)
    {
        ObjectStructure os=new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor=new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------------------");
        visitor=new ConcreteVisitorB();
        os.accept(visitor);
    }
}
//���������
interface Visitor
{
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}
//���������A��
class ConcreteVisitorA implements Visitor
{
    public void visit(ConcreteElementA element)
    {
        System.out.println("���������A����-->"+element.operationA());
    }
    public void visit(ConcreteElementB element)
    {
        System.out.println("���������A����-->"+element.operationB());
    }
}
//���������B��
class ConcreteVisitorB implements Visitor
{
    public void visit(ConcreteElementA element)
    {
        System.out.println("���������B����-->"+element.operationA());
    }
    public void visit(ConcreteElementB element)
    {
        System.out.println("���������B����-->"+element.operationB());
    }
}
//����Ԫ����
interface Element
{
    void accept(Visitor visitor);
}
//����Ԫ��A��
class ConcreteElementA implements Element
{
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
    public String operationA()
    {
        return "����Ԫ��A�Ĳ�����";
    }
}
//����Ԫ��B��
class ConcreteElementB implements Element
{
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
    public String operationB()
    {
        return "����Ԫ��B�Ĳ�����";
    }
}
//����ṹ��ɫ
class ObjectStructure
{   
    private List<Element> list=new ArrayList<Element>();   
    public void accept(Visitor visitor)
    {
        Iterator<Element> i=list.iterator();
        while(i.hasNext())
        {
            ((Element) i.next()).accept(visitor);
        }      
    }
    public void add(Element element)
    {
        list.add(element);
    }
    public void remove(Element element)
    {
        list.remove(element);
    }
}