package com.my.mywebapp.client.ui;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.user.client.Window;
import com.my.mywebapp.shared.models.PeopleList;
import com.my.mywebapp.client.controller.WebAppController;

public class CellTableExample {

	private Integer Sid;
	private String Ssurname;
	private String Sname;
	private String Spatr;

	public Integer GetSid(){ return Sid; }
	public String GetSsurname(){ return Ssurname; }
	public String GetSname(){ return Sname; }
	public String GetSpatr(){ return Spatr; }

        private List<PeopleList> peopleList = Arrays.asList();

	private CellTable<PeopleList> table;

	public CellTableExample() {

		Sid = 0;
		Ssurname = "";
		Sname = "";
		Spatr = "";		

		// Create a CellTable.
		table = new CellTable<PeopleList>();

		// // Create id column.
		// Column<Contact, Number> idColumn = new Column<Contact, Number>(new NumberCell()) {
		// 	@Override
		// 	public Integer getValue(Contact contact, Number num) {
		// 		return contact.GetID();
		// 	}
		// };
		// Create id column.
		TextColumn<PeopleList> idColumn = new TextColumn<PeopleList>() {
			@Override
			public String getValue(PeopleList contact) {
				return Integer.toString(contact.getId());
			}
		};


		// Create surname column.
		TextColumn<PeopleList> surnameColumn = new TextColumn<PeopleList>() {
			@Override
			public String getValue(PeopleList contact) {
				return contact.getSurname();
			}
		};

		// Make the name column sortable.
		surnameColumn.setSortable(true);

		// Create name column.
		TextColumn<PeopleList> nameColumn = new TextColumn<PeopleList>() {
			@Override
			public String getValue(PeopleList contact) {
				return contact.getName();
			}
		};

		// Make the name column sortable.
		// nameColumn.setSortable(true);

		// Create patronymic column.
		TextColumn<PeopleList> patrColumn = new TextColumn<PeopleList>() {
			@Override
			public String getValue(PeopleList contact) {
				return contact.getPatronymic();
			}
		};

		// Add the columns.
//		table.addColumn(idColumn, "ID");
		table.addColumn(surnameColumn, "Фамилия");
		table.addColumn(nameColumn, "Имя");
		table.addColumn(patrColumn, "Отчество");

		final SingleSelectionModel<PeopleList> selectionModel = new SingleSelectionModel<PeopleList>();
		table.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			public void onSelectionChange(SelectionChangeEvent event) {

				PeopleList selectedContact = selectionModel.getSelectedObject();
				if (selectedContact != null) {
					Sid = selectedContact.getId();
					Ssurname = selectedContact.getSurname();
					Sname = selectedContact.getName();
					Spatr = selectedContact.getPatronymic();	
					Window.alert(
							"Selected: surname: " + selectedContact.getSurname() + ", Second col: " + selectedContact.getName() + ", id col: " + selectedContact.getId());
					RootPanel.get("EditFormContainer").clear();
				}
			}
		});

		// Add it to the root panel.
		// RootPanel.get("TableContainer").add(table);
	}

        public void InitTableExample(List<PeopleList> lst) {
                peopleList =  lst;

		// Create a data provider.
		ListDataProvider<PeopleList> dataProvider = new ListDataProvider<PeopleList>();

		// Connect the table to the data provider.
		dataProvider.addDataDisplay(table);

		// Add the data to the data provider, which automatically pushes it to the
		// widget.
		List<PeopleList> list = dataProvider.getList();

                //List<PeopleList> tmp = Arrays.asList();
//                List<PeopleList> tmp = cntrl.GetList();

                //Window.alert(tmp);
                String str="3 TABLE adding data:";
                if (!peopleList.isEmpty()) {
                    for (PeopleList contact : peopleList) {
                            list.add(contact);
                            str = str + contact.getSurname();
                    }
                }
                Window.alert(str);

		// Add a ColumnSortEvent.ListHandler to connect sorting to the
		// java.util.List.
		ListHandler<PeopleList> columnSortHandler = new ListHandler<PeopleList>(list);
		columnSortHandler.setComparator(table.getColumn(0), new Comparator<PeopleList>() {
			public int compare(PeopleList o1, PeopleList o2) {
				if (o1 == o2) {
					return 0;
				}

				// Compare the name columns.
				if (o1 != null) {
					return (o2 != null) ? o1.getSurname().compareTo(o2.getSurname()) : 1;
				}
				return -1;
			}
		});
		table.addColumnSortHandler(columnSortHandler);

		// We know that the data is sorted alphabetically by default.
		table.getColumnSortList().push(table.getColumn(0));

        }

	public CellTable GetTable() {
		return table;
	}

//	public List<PeopleList> SetPeopleList() {
//		return peopleList;
//	}
}