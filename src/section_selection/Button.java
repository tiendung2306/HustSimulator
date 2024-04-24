package section_selection;

public class Button extends Section {
    public Button(Section_selection section_selection)  {
        super(section_selection);

    }

    
    @Override protected void OnClick(){
        section_selection.close();
    }
}
