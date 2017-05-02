package renatosrib

import org.jbehave.core.configuration.Configuration
import org.jbehave.core.configuration.MostUsefulConfiguration
import org.jbehave.core.io.CodeLocations
import org.jbehave.core.io.LoadFromClasspath
import org.jbehave.core.junit.JUnitStory
import org.jbehave.core.reporters.StoryReporterBuilder
import org.jbehave.core.steps.InjectableStepsFactory
import org.jbehave.core.steps.InstanceStepsFactory


import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;

class AcceptanceTest extends JUnitStory {

        @Override
        public Configuration configuration() {
            return new MostUsefulConfiguration()
                    .useStoryLoader(new LoadFromClasspath(this.getClass()))
                    .useStoryReporterBuilder(new StoryReporterBuilder()
                    .withFormats(CONSOLE, HTML, TXT)
                    .withCodeLocation(
                    CodeLocations.codeLocationFromPath("build/jbehave")));
        }

    @Override
    public InjectableStepsFactory stepsFactory() {
        // varargs, podemos ter mais de uma classe de steps
        return new InstanceStepsFactory(configuration(), new CompraDeProdutosSteps());
    }
}
