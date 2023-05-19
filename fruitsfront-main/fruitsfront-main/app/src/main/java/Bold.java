public class Bold {
    TextView textView = findViewById(R.id.textView);

    // Créer un objet Typeface pour le style gras
    Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);

// Appliquer le style gras à la TextView
textView.setTypeface(boldTypeface);
}
