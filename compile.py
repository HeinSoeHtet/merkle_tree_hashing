import os
import subprocess

# Define paths
src_dir = "src"  # Directory containing your Java source files
test_dir = "test"  # Directory containing your test Java files
bin_dir = "bin"  # Directory to store compiled class files

# Create the bin directory if it doesn't exist
if not os.path.exists(bin_dir):
    os.makedirs(bin_dir)

# Collect all .java files from src and test directories
java_files = []
for directory in [src_dir, test_dir]:  # Iterate over both directories
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith(".java"):
                java_files.append(os.path.join(root, file))

# Compile all Java files with package structure preserved
for java_file in java_files:
    # Command to compile the Java file with output to the bin directory
    compile_command = ["javac", "-d", bin_dir, java_file]

    # Print the compile command for debugging
    print(f"Compiling: {java_file}")

    # Run the compilation command
    result = subprocess.run(compile_command, capture_output=True, text=True)

    # Check for compilation errors
    if result.returncode != 0:
        print(f"Error compiling {java_file}:")
        print(result.stderr)

print("Compilation process completed.")
