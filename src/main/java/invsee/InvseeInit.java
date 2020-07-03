package invsee;

import invsee.commands.InvSeeCommand;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CommandRegistry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvseeInit implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "mahanmmi_simple_invsee";
    public static final String MOD_NAME = "SimpleInvSee";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        CommandRegistry.INSTANCE.register(false, InvSeeCommand::register);
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}