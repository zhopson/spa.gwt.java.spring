package com.my.mywebapp.client;

import com.my.mywebapp.shared.FieldVerifier;
import com.my.mywebapp.client.ui.CellTableExample;
import com.my.mywebapp.shared.models.PeopleList;
//import com.my.mywebapp.shared.models.People;
import com.my.mywebapp.client.controller.WebAppController;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
//import com.google.gwt.event.dom.client.KeyPressEvent;
//import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.ScrollPanel;
import java.util.List;
//import java.util.stream.Collectors;
import java.util.ArrayList;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SpaGwtJava implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
//  private static final String SERVER_ERROR = "An error occurred while "
//      + "attempting to contact the server. Please check your network "
//      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
//  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    private boolean IsEditMode = false;

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    final Button sendButton = new Button("Сохранить");
    final Button NewButton = new Button("Новый сотрудник");
    final Button EditButton = new Button("Изменить данные");
    final Button DelButton = new Button("Удалить");
    final Button cancelButton = new Button("Отмена");
    final Button fillButton = new Button("Сгенерировать 25 записей");
    
    final TextBox surnameField = new TextBox();
    surnameField.setText("Петров");
    final TextBox nameField = new TextBox();
    nameField.setText("Петр");
    final TextBox patrField = new TextBox();
    patrField.setText("Петрович");

    
    final Label errorLabel = new Label();
    final Label cLabel = new Label();
    cLabel.setText("Введите данные:");
    final Label newLabel = new Label();
    newLabel.setText("Новая запись:");
    final Label editLabel = new Label();
    editLabel.setText("Редактирование записи:");

    // We can add style names to widgets
    sendButton.addStyleName("sendButton");
    NewButton.addStyleName("sendButton");
    EditButton.addStyleName("sendButton");
    DelButton.addStyleName("sendButton");
    cancelButton.addStyleName("sendButton");
    fillButton.addStyleName("fillButton");

    newLabel.addStyleName("headerText");
    editLabel.addStyleName("headerText");

    final HorizontalPanel hp = new HorizontalPanel();
    hp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
    hp.add(NewButton);
    hp.add(EditButton);
    hp.add(DelButton);

    RootPanel.get("ToolBoxContainer").add(hp);

    final VerticalPanel vp = new VerticalPanel();
    //vp.setVerticalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

    vp.add(cLabel);
    vp.add(surnameField);
    vp.add(nameField);
    vp.add(patrField);

    final HorizontalPanel hp1 = new HorizontalPanel();
    hp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
    hp1.add(sendButton);
    hp1.add(cancelButton);
////////////////////////////////////////////////////////////////////////////////////////////////////////
    final CellTableExample CTable = new CellTableExample();
    //CellTable tab = CTable.GetTable();
////////////////////////////////////////////////////////////////////////////////////////////////////////
//такой вариант не работает:
//    WebAppController cntrl = new WebAppController(); // 1 
//    cntrl.loadPeopleList(); // 3 вызывается после 2
//    CTable.InitTableExample(cntrl.GetList()); // 2
//проблема в WebAppController 1 4 5 2 3
////////////////////////////////////////////////////////////////////////////////////////////////////////
// Получение Списка сотрудников с БД
    WebAppController cntrl = new WebAppController(CTable);
    cntrl.loadPeopleList();
////////////////////////////////////////////////////////////////////////////////////////////////////////

    //setWidget(new ScrollPanel(vPanel));

//    VerticalPanel mvp = CTable.GetTabPanel();
    RootPanel.get("errorLabelContainer").add(errorLabel);

//    final HorizontalPanel hp2 = new HorizontalPanel();
//    hp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//    hp2.add(fillButton);
//
//    RootPanel.get("leftToolsContainer").add(hp2);
    RootPanel.get("leftToolsContainer").add(fillButton);

//    RootPanel.get("TableContainer").add(new ScrollPanel(mvp));

    // Focus the cursor on the name field when the app loads
//    nameField.setFocus(true);
//    nameField.selectAll();

    // Create the popup dialog box
//    final DialogBox dialogBox = new DialogBox();
//    dialogBox.setText("Remote Procedure Call");
//    dialogBox.setAnimationEnabled(true);
//    final Button closeButton = new Button("Close");
//    // We can set the id of a widget by accessing its Element
//    closeButton.getElement().setId("closeButton");
//    final Label textToServerLabel = new Label();
//    final HTML serverResponseLabel = new HTML();
//    VerticalPanel dialogVPanel = new VerticalPanel();
//    dialogVPanel.addStyleName("dialogVPanel");
//    dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
//    dialogVPanel.add(textToServerLabel);
//    dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
//    dialogVPanel.add(serverResponseLabel);
//    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
//    dialogVPanel.add(closeButton);
//    dialogBox.setWidget(dialogVPanel);

    // Add a handler to close the DialogBox
//    closeButton.addClickHandler(new ClickHandler() {
//      public void onClick(ClickEvent event) {
//        dialogBox.hide();
//        sendButton.setEnabled(true);
//        sendButton.setFocus(true);
//      }
//    });
    // Add a handler to show new form
//    fictionButton.addClickHandler(new ClickHandler() {
//      public void onClick(ClickEvent event) {
////        WebAppController cntrl = new WebAppController();
////        cntrl.loadPeopleList();
////        CTable.InitTableExample(cntrl.GetList());
//      }
//    });
////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Add a handler to show new form
    NewButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        surnameField.setText("Фамилия");
        nameField.setText("Имя ");
        patrField.setText("Отчество");     

        RootPanel.get("EditFormContainer").add(vp);
        RootPanel.get("EditFormContainer").add(hp1);
//        fictionButton.fireEvent(new ClickEvent() { } );
        IsEditMode = false;
        RootPanel.get("opLabelContainer").clear();
        RootPanel.get("opLabelContainer").add(newLabel);
//        Window.alert("edit: " + IsEditMode);       
      }
    });
    // Add a handler to save new/update people
    sendButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {

        String surnameToServer = surnameField.getText();
        String nameToServer = nameField.getText();
        String patrToServer = patrField.getText();

        if (IsEditMode) {
            int id = CTable.GetSid();
            //Window.alert("edit id: " + id);
            cntrl.updatePeople(id, surnameToServer, nameToServer, patrToServer);            
        } else {
            cntrl.savePeople(surnameToServer, nameToServer, patrToServer);
        }
        RootPanel.get("EditFormContainer").clear();
        RootPanel.get("opLabelContainer").clear();
      }
    });
    // Add a handler to hide edit form
    cancelButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        RootPanel.get("EditFormContainer").clear();
        RootPanel.get("opLabelContainer").clear();
      }
    });
    // Add a handler to show edit form  
    EditButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (!CTable.GetSsurname().equals("")) {
            surnameField.setText(CTable.GetSsurname());
            nameField.setText(CTable.GetSname());
            patrField.setText(CTable.GetSpatr());    

            RootPanel.get("EditFormContainer").add(vp);
            RootPanel.get("EditFormContainer").add(hp1);
            
            IsEditMode = true;
//            Window.alert("edit: " + IsEditMode);
        RootPanel.get("opLabelContainer").clear();
        RootPanel.get("opLabelContainer").add(editLabel);


        }
      }
    });
    // Add a handler to del element  
    DelButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (!CTable.GetSsurname().equals("")) {
            int id = CTable.GetSid();
            //Window.alert("edit id: " + id);
            cntrl.deletePeople(id);
            ListDataProvider<PeopleList> dataProvider =  CTable.GetDataProvider();
            List<PeopleList> list = dataProvider.getList();
//            PeopleList match = list.stream().findFirst(u -> u.getSurname().equals(CTable.GetSsurname())).get();
            PeopleList match = list.stream().filter(u -> u.getSurname().equals(CTable.GetSsurname()) && u.getName().equals(CTable.GetSname())).findFirst().orElse(null);
            //Window.alert("match: " + match);
            if (match != null) {
                int indexOf = list.indexOf(match);
                list.remove(indexOf);
                dataProvider.refresh();
            }
        }
      }
    });
    // Add a handler to fille base with some people
    fillButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {

        cntrl.fillDBfakeData();

        RootPanel.get("EditFormContainer").clear();
        RootPanel.get("opLabelContainer").clear();
      }
    });

/////////////////////////////////////////////////////////////////////////////////////////////////////

    // Create a handler for the sendButton and nameField
//    class MyHandler implements ClickHandler, KeyUpHandler {
//      /**
//       * Fired when the user clicks on the sendButton.
//       */
//      public void onClick(ClickEvent event) {
//        sendNameToServer();
//        RootPanel.get("EditFormContainer").clear();
//      }
//
//      /**
//       * Fired when the user types in the nameField.
//       */
//      public void onKeyUp(KeyUpEvent event) {
//        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
//          sendNameToServer();
//        }
//      }
//
//      /**
//       * Send the name from the nameField to the server and wait for a response.
//       */
//      private void sendNameToServer() {
//        // First, we validate the input.
//        errorLabel.setText("");
//        String textToServer = nameField.getText();
//        if (!FieldVerifier.isValidName(textToServer)) {
//          errorLabel.setText("Please enter at least four characters");
//          return;
//        }
//        
//        // Then, we send the input to the server.
//        sendButton.setEnabled(false);
//        textToServerLabel.setText(textToServer);
//        serverResponseLabel.setText("");
//        greetingService.greetServer(textToServer, new AsyncCallback<String>() {
//          public void onFailure(Throwable caught) {
//            // Show the RPC error message to the user
//            dialogBox.setText("Remote Procedure Call - Failure");
//            serverResponseLabel.addStyleName("serverResponseLabelError");
//            serverResponseLabel.setHTML(SERVER_ERROR);
//            dialogBox.center();
//            closeButton.setFocus(true);
//          }
//
//          public void onSuccess(String result) {
//            dialogBox.setText("Remote Procedure Call");
//            serverResponseLabel.removeStyleName("serverResponseLabelError");
//            serverResponseLabel.setHTML(result);
//            dialogBox.center();
//            closeButton.setFocus(true);
//          }
//        });
//      }
//    }
//
//    // Add a handler to send the name to the server
//    MyHandler handler = new MyHandler();
//    sendButton.addClickHandler(handler);
//    nameField.addKeyUpHandler(handler);

  }

}
