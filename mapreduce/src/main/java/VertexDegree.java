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


    public static void main(String[] args) throws IOException{

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

        JobClient.runJob(conf);
    }
}
