package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.violations.KlocWorkAdapter;
import io.jenkins.plugins.analysis.core.model.ReportScanningTool;

import org.jenkinsci.Symbol;
import hudson.Extension;

/**
 * Provides a parser and customized messages for Klocwork.
 *
 * @author Ullrich Hafner
 */
public class KlocWork extends ReportScanningTool {
    private static final long serialVersionUID = -4352260844574399784L;
    static final String ID = "klocwork";

    /** Creates a new instance of {@link KlocWork}. */
    @DataBoundConstructor
    public KlocWork() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public KlocWorkAdapter createParser() {
        return new KlocWorkAdapter();
    }

    /** Descriptor for this static analysis tool. */
    @Symbol("klocWork")
    @Extension
    public static class Descriptor extends ReportScanningToolDescriptor {
        /** Creates the descriptor instance. */
        public Descriptor() {
            super(ID);
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Violations_Klocwork();
        }
    }
}
