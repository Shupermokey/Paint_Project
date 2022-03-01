package controller;

import Commands.CopyShapeCommand;
import Commands.DeleteShapeCommand;
import Commands.GroupShapeCommand;
import Commands.PasteShapeCommand;
import Commands.RedoCommand;
import Commands.UndoCommand;
import Commands.UngroupShapeCommand;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IEventCallback;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() {
        setupEvents();
    }
 
    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
        uiModule.addEvent(EventName.COPY, () -> new CopyShapeCommand().run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteShapeCommand().run());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteShapeCommand().run());
        uiModule.addEvent(EventName.GROUP, () -> new GroupShapeCommand().run());
        uiModule.addEvent(EventName.UNGROUP, () -> new UngroupShapeCommand().run());
        
    }
}
