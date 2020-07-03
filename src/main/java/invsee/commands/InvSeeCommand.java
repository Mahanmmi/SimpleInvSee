package invsee.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public final class InvSeeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        String playerName = "";
        LiteralArgumentBuilder<ServerCommandSource> literal = CommandManager.literal("invsee");
        literal
                .then(CommandManager
                        .argument(playerName, EntityArgumentType.player()))
                .requires(source -> source.hasPermissionLevel(4))
                .executes(source -> execute(source.getSource(), EntityArgumentType.getPlayer(source, playerName)));
        dispatcher.register(literal);
    }

    private static int execute(ServerCommandSource source,ServerPlayerEntity  target) throws CommandSyntaxException {
        PlayerInventory targetInventory = target.inventory;
        Text text = new LiteralText(targetInventory.toString());
        source.getPlayer().sendMessage(text, false);
        return 1;
    }
}
