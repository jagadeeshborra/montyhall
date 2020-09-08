package com.game.montyhall.simulator.util;

import com.game.montyhall.simulator.model.Output;

import java.util.List;

public final class MontyHallUtil {

    public static String covertToHTML(List<Output> outputs, String winPercentage, int simulationSize)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head><meta charset=\"UTF-8\">");
        sb.append("</head>");
        int count = outputs.size();
        if(count > 0 && count <= simulationSize) {
            buildTableHeader(sb);
            buildData(sb, outputs, winPercentage);
        }
        else
            buildOnlyPercentage(sb, winPercentage);
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();

    }
    private static void buildTableHeader(StringBuilder sb)
    {
        sb.append("<table>");
        sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: right;\"> Iteration");
        sb.append("</th>");
        sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: center;\"> Door 1");
        sb.append("</th>");
        sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: center;\"> Door 2");
        sb.append("</th>");
        sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: center;\"> Door 3");
        sb.append("</th>");
        sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: right;\"> Selected");
        sb.append("</th>");
        sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: right;\"> Switched");
        sb.append("</th>");
        sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: right;\"> Win");
        sb.append("</th>");
    }

    private static void buildData(StringBuilder sb, List<Output> outputs, String winPercentage)
    {
        for (Output output : outputs) {
            sb.append("<tr>");
            sb.append("<td style = \"padding: 6px; text-align: right;\"> ").append(output.getIteration());
            sb.append("</td>");
            sb.append("<td style = \"padding: 6px; text-align: center;\"> ").append(displayEmoji(output.getDoors()[0]));
            sb.append("</td>");
            sb.append("<td style = \"padding: 6px; text-align: center;\"> ").append(displayEmoji(output.getDoors()[1]));
            sb.append("</td>");
            sb.append("<td style = \"padding: 6px; text-align: center;\"> ").append(displayEmoji(output.getDoors()[2]));
            sb.append("</td>");
            sb.append("<td style = \"padding: 6px; text-align: right;\"> ").append(output.getSelected());
            sb.append("</td>");
            sb.append("<td style = \"padding: 6px; text-align: right;\"> ").append(output.isSwitched());
            sb.append("</td>");
            sb.append("<td style = \"padding: 6px; text-align: right;\"> ").append(output.isWin());
            sb.append("</td>");
            sb.append("</tr>");
        }
        sb.append("<tr>");
        sb.append("<td style = \"padding: 6px; text-align: left;\"> " + " Win Percentage : ").append(winPercentage);
        sb.append("</td>");
        sb.append("</tr>");
        sb.append("</table>");
    }
    private static String buildOnlyPercentage(StringBuilder sb, String winPercentage)
    {
        sb.append("<table>");
        sb.append("<tr>");
        sb.append("<td style = \"padding: 6px; text-align: left;\"> " + " Win Percentage : ").append(winPercentage);
        sb.append("</td>");
        sb.append("</tr>");
        sb.append("</table>");
        return sb.toString();
    }
    private static String displayEmoji(int value)
    {
        if(value == 0)
            return "<p>&#128016;</p>";
        else
            return "<p>&#x1F697;</p>";
    }
}
