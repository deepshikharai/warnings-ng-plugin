package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.violations.ResharperInspectCodeAdapter;
import io.jenkins.plugins.analysis.core.model.IconLabelProvider;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisLabelProvider;
import io.jenkins.plugins.analysis.core.model.ReportScanningTool;

import org.jenkinsci.Symbol;
import hudson.Extension;

/**
 * Provides a parser and customized messages for Resharper Inspections.
 *
 * @author Ullrich Hafner
 */
public class ResharperInspectCode extends ReportScanningTool {
    private static final long serialVersionUID = 7249388335877895890L;
    static final String ID = "resharper";

    /** Creates a new instance of {@link ResharperInspectCode}. */
    @DataBoundConstructor
    public ResharperInspectCode() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public ResharperInspectCodeAdapter createParser() {
        return new ResharperInspectCodeAdapter();
    }

    /** Descriptor for this static analysis tool. */
    @Symbol("resharperInspectCode")
    @Extension
    public static class Descriptor extends ReportScanningToolDescriptor {
        /** Creates the descriptor instance. */
        public Descriptor() {
            super(ID);
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Warnings_ReshaperInspectCode_ParserName();
        }

        @Override
        public boolean canScanConsoleLog() {
            return false;
        }

        @Override
        public StaticAnalysisLabelProvider getLabelProvider() {
            return new IconLabelProvider(getId(), getDisplayName());
        }
    }
}
