package main.java;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

/**
 * Created by abhishek on 9/15/14.
 */
public class VertexDegree {

    public static JobConf getJobConf(String[] args){

        JobConf conf = new JobConf(VertexDegree.class);
        conf.setJobName("vertexDegreeCount");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setMapperClass(VertexDegreeMapper.class);
        conf.setCombinerClass(VertexDegreeReducer.class);
        conf.setReducerClass(VertexDegreeReducer.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        return conf;
    }


    public static void main(String[] args) throws IOException{

        if(args.length != 2){
            System.err.println("Invalid Input Format");
            System.out.println("Usage: bin/hadoop jar <jar File> <className> <source dir> <output dir> \n");
            System.exit(-1);
        }
        JobConf conf = VertexDegree.getJobConf(args);
        JobClient.runJob(conf);
    }
}