class StockMarketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock_market)

        // Configurar botón Volver
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Configurar datos de las acciones
        setupStock(R.id.nvidiaItem, "NVIDIA", "289.53", "+0.05%")
        setupStock(R.id.amazonItem, "AMAZON", "111.20", "+0.05%")
        setupStock(R.id.amdItem, "AMD", "97.40", "+0.05%")
        setupStock(R.id.aaplItem, "AAPL - APPLE INC", "172.075", "+1.93%")
        setupStock(R.id.sanItem, "SAN - BANCO SANTANDER S.A", "324.46", "+1.93%")
        setupStock(R.id.ggalItem, "GGAL - GRUPO FINANCIERO GALICIA S.A.", "315.00", "+1.93%")
        setupStock(R.id.googlItem, "GOOGL - ALPHABET INC", "455.56", "+1.93%")
        setupStock(R.id.tslaItem, "TSLA - TESLA, INC", "67.92", "+1.93%")
    }

    private fun setupStock(itemId: Int, name: String, price: String, change: String) {
        val itemView = findViewById<View>(itemId)
        itemView.findViewById<TextView>(R.id.stockName).text = name
        itemView.findViewById<TextView>(R.id.stockPrice).text = price

        val changeView = itemView.findViewById<TextView>(R.id.stockChange)
        changeView.text = change
        changeView.setTextColor(
            if (change.startsWith("+")) Color.parseColor("#4CAF50")
            else Color.parseColor("#F44336")
        )
    }
}