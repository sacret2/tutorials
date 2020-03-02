package com.google.gwt.sample.stockwatcher.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StockWatcher implements EntryPoint {
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable stocksFlexTable = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox newSymbolTextBox = new TextBox();
	private Button addStockButton = new Button("Add");
	private Label lastUpdatedLabel = new Label();

	private ArrayList<String> stockSymbols = new ArrayList();
	private final int REFRESH_INTERVAL = 5000;

	/**
	 * Entry point method.
	 */
	public void onModuleLoad() {
		// Create table for stock data.
		stocksFlexTable.setText(0, 0, "Symbol");
		stocksFlexTable.setText(0, 1, "Price");
		stocksFlexTable.setText(0, 2, "Change");
		stocksFlexTable.setText(0, 3, "Remove");

		addPanel.add(newSymbolTextBox);
		addPanel.add(addStockButton);

		mainPanel.add(stocksFlexTable);
		mainPanel.add(addPanel);
		mainPanel.add(lastUpdatedLabel);

		RootPanel.get("stockList").add(mainPanel);

		newSymbolTextBox.setFocus(true);

		Timer refreshTimer = new Timer() {

			@Override
			public void run() {
				refreshWatchList();

			}

		};
		refreshTimer.scheduleRepeating(REFRESH_INTERVAL);

		// Listen for mouse events on the Add button.
		addStockButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addStock();
			}
		});

		newSymbolTextBox.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
					addStock();
			}
		});

		// refresh stock prices
		refreshWatchList();
	}

	/**
	 * Generate random stock prices.
	 */
	private void refreshWatchList() {
		final double MAX_PRICE = 100.0; // $100.00
		final double MAX_PRICE_CHANGE = 0.02; // +/- 2%

		StockPrice[] prices = new StockPrice[stockSymbols.size()];
		for (int i = 0; i < stockSymbols.size(); i++) {
			double price = Random.nextDouble() * MAX_PRICE;
			double change = price * MAX_PRICE_CHANGE * (Random.nextDouble() * 2.0 - 1.0);

			prices[i] = new StockPrice(stockSymbols.get(i), price, change);
		}

		updateTable(prices);
	}

    /**
     * update prices of all stocks
     * @param prices
     */
    private void updateTable(StockPrice[] prices) {
        for (int i = 0; i < prices.length; i++) {
          updateTable(prices[i]);
        }

        // 
        DateTimeFormat dateFormat = DateTimeFormat.getFormat(
        		DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);
        lastUpdatedLabel.setText("Last updated: " + dateFormat.format(new Date()));
      }
	
	private void updateTable(StockPrice price) {
		     // Make sure the stock is still in the stock table.
		     if (!stockSymbols.contains(price.getSymbol())) {
		       return;
		     }

		     int row = stockSymbols.indexOf(price.getSymbol()) + 1;

		     // Format the data in the Price and Change fields.
		     String priceText = NumberFormat.getFormat("#,##0.00").format(
		         price.getPrice());
		     NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
		     String changeText = changeFormat.format(price.getChange());
		     String changePercentText = changeFormat.format(price.getChangePercent());

		     // Populate the Price and Change fields with new data.
		     stocksFlexTable.setText(row, 1, priceText);
		     stocksFlexTable.setText(row, 2, changeText + " (" + changePercentText
		         + "%)");
		}
	
	

	
	/**
	 * Add stock to FlexTable. Executed when the user clicks the addStockButton or
	 * presses enter in the newSymbolTextBox.
	 */
	private void addStock() {
		final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
		newSymbolTextBox.setFocus(true);

		// Stock code must be between 1 and 10 chars that are numbers, letters, or dots.
		if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
			Window.alert("'" + symbol + "' is not a valid symbol.");
			newSymbolTextBox.selectAll();
			return;
		}

		if (stockSymbols.contains(symbol))
			return;

		final int row = stocksFlexTable.getRowCount();
		stockSymbols.add(symbol);
		stocksFlexTable.setText(row, 0, symbol);

		Button removeStockBtn = new Button("X");

		removeStockBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int ind = stockSymbols.indexOf(symbol);
				stockSymbols.remove(ind);
				stocksFlexTable.removeRow(ind + 1);
			}
		});

		this.stocksFlexTable.setWidget(row, 3, removeStockBtn);

	}
}