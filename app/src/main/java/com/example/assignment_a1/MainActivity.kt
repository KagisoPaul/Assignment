import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_a1.R

class MainActivity : AppCompatActivity() {

    private lateinit var ageInput: EditText
    private lateinit var compareButton: Button
    private lateinit var resultText: TextView
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageInput = findViewById(R.id.age_input)
        compareButton = findViewById(R.id.compare_button)
        resultText = findViewById(R.id.result_text)
        clearButton = findViewById(R.id.clear_button)

        compareButton.setOnClickListener {
            compareAges()
        }

        clearButton.setOnClickListener {
            clearInputAndResult()
        }
    }

    private fun compareAges() {
        val ageString = ageInput.text.toString()

        if (ageString.isEmpty()) {
            resultText.text = getString(R.string.error_empty_age)
            return
        }

        val age = ageString.toIntOrNull()
        if (age == null) {
            resultText.text = getString(R.string.error_invalid_age_format)
            return
        }

        if (age !in 20..100) {
            resultText.text = getString(R.string.error_age_out_of_range)
            return
        }

        val historicalFigure = getHistoricalFigure(age)
        resultText.text = "${historicalFigure.name} passed away at the age of ${historicalFigure.age}.\n\n${historicalFigure.description}"
    }

    private fun getHistoricalFigure(age: Int): HistoricalFigure {
        return when (age) {
            95 -> HistoricalFigure("Nelson Mandela", 95, "Nelson Mandela was a South African anti-apartheid revolutionary, political leader, and philanthropist who served as President of South Africa from 1994 to 1999.")
            52 -> HistoricalFigure("William Shakespeare", 52, "William Shakespeare was an English playwright, poet, and actor, widely regarded as the greatest writer in the English language and the world's greatest dramatist.")
            67 -> HistoricalFigure("Leonardo da Vinci", 67, "Leonardo da Vinci was an Italian polymath of the Renaissance whose areas of interest included invention, painting, sculpting, architecture, science, music, mathematics, engineering, literature, anatomy, geology, astronomy, botany, paleontology, and cartography. He has been variously called the father of paleontology, ichnology, and architecture, and he is widely considered one of the greatest painters of all time.")
            76 -> HistoricalFigure("Albert Einstein", 76, "Albert Einstein was a German-born theoretical physicist who developed the theory of relativity, one of the two pillars of modern physics (alongside quantum mechanics). His work is also known for its influence on the philosophy of science. He is best known to the general public for his mass–energy equivalence formula E = mc^2, which has been dubbed \"the world's most famous equation\".")
            78 -> HistoricalFigure("Mahatma Gandhi", 78, "Mahatma Gandhi was an Indian lawyer, anti-colonial nationalist, and political ethicist, who employed nonviolent resistance to lead the successful campaign for India's independence from British rule, and in turn inspired movements for civil rights and freedom across the world.")
            84 -> HistoricalFigure("Isaac Newton", 84, "Sir Isaac Newton PRS was an English mathematician, physicist, astronomer, theologian, and author who is widely recognised as one of the greatest mathematicians and most influential scientists of all time and as a key figure in the scientific revolution. His book Philosophiæ Naturalis Principia Mathematica, first published in 1687, laid the foundations of classical mechanics. Newton also made seminal contributions to optics, and shares credit with Gottfried Wilhelm Leibniz for developing the infinitesimal calculus.")
            73 -> HistoricalFigure("Charles Darwin", 73, "Charles Robert Darwin FRS FRGS FLS FZS was an English naturalist, geologist, and biologist, best known for his contributions to the science of evolution. His proposition that all species of life have descended over time from common ancestors is now widely accepted, and considered a foundational concept in science. In a joint publication with Alfred Russel Wallace, he introduced his scientific theory that this branching pattern of evolution resulted from a process that he called natural selection, in which the struggle for existence has a similar effect to the artificial selection involved in selective breeding.")
            39 -> HistoricalFigure("Cleopatra", 39, "Cleopatra VII Philopator was the last active ruler of the Ptolemaic Kingdom of Egypt. As a member of the Ptolemaic dynasty, she was a descendant of its founder Ptolemy I Soter, a Macedonian Greek general and companion of Alexander the Great. After the death of Cleopatra, Egypt became a province of the Roman Empire, marking the end of the Hellenistic period that had lasted since the reign of Alexander. Her native language was Koine Greek and she was the only Ptolemaic ruler to learn the Egyptian language.")
            35 -> HistoricalFigure("Wolfgang Amadeus Mozart", 35, "Wolfgang Amadeus Mozart, baptised as Johannes Chrysostomus Wolfgangus Theophilus Mozart, was a prolific and influential composer of the Classical period. Born in Salzburg, in the Holy Roman Empire, Mozart showed prodigious ability from his earliest childhood. He composed over 600 works, many acknowledged as pinnacles of symphonic, concertante, chamber, operatic, and choral music. He is among the most enduringly popular of classical composers, and his influence is profound on subsequent Western art music. Ludwig van Beethoven composed his own early works in the shadow of Mozart, and Joseph Haydn wrote: \"posterity will not see such a talent again in 100 years\".")
            39 -> HistoricalFigure("Amelia Earhart", 39, "Amelia Mary Earhart was an American aviation pioneer and author. Earhart was the first female aviator to fly solo across the Atlantic Ocean. She set many other records, wrote best-selling books about her flying experiences, and was instrumental in the formation of The Ninety-Nines, an organization for female pilots.")
            66 -> HistoricalFigure("Marie Curie", 66, "Marie Skłodowska Curie was a Polish and naturalized-French physicist and chemist who conducted pioneering research on radioactivity. She was the first woman to win a Nobel Prize, the first person and the only woman to win the Nobel Prize twice, and the only person to win the Nobel Prize in two scientific fields. Her achievements included the development of the theory of radioactivity (a term that she coined), techniques for isolating radioactive isotopes, and the discovery of two elements, polonium and radium.")
            else -> HistoricalFigure("Unknown", age, "No information available.")
        }
    }


    private fun clearInputAndResult() {
        ageInput.text.clear()
        resultText.text = ""
    }
}

data class HistoricalFigure(val name: String, val age: Int, val description: String)

fun String?.isEmpty(): Boolean {
    return this == null || this.isEmpty()
}

fun String?.toIntOrNull(): Int? {
    return try {
        this?.toIntOrNull()
    } catch (e: NumberFormatException) {
        null
    }
}
